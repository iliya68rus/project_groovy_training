import groovy.sql.Sql

class QueryBuilder {
    def sql
    def entityClass
    def whereClause = []

    QueryBuilder(Sql sql, Class entityClass) {
        this.sql = sql
        this.entityClass = entityClass
    }

    def from(Class entityClass) {
        this.entityClass = entityClass
        this
    }

    def where(Closure closure) {
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        this
    }

    def or(Closure closure) {
        whereClause.add('(')
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        whereClause.add(')')
        this
    }

    def eq(String column, Object value) {
        whereClause.add("${column} = ${value}")
        this
    }

    def nonEq(String column, Object value) {
        whereClause.add("${column} IS NOT ${value}")
        this
    }

    def buildQuery() {
        def tableName = entityClass.simpleName.toLowerCase()
        def query = "SELECT * FROM ${tableName}"
        if (whereClause) {
            query += " WHERE " + whereClause.join(' OR ')
        }
        query
    }

    def execute() {
        def query = buildQuery()
        println "Выполненый запрос: ${query}"
        sql.eachRow(query) { row ->
            println row
        }
    }
}

