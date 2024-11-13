import groovy.sql.Sql

class QueryBuilder {
    def sql
    def entityClass
    def whereClause = []
    def params = [:]

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
        def orClause = []
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        if (orClause.size() > 0) {
            whereClause.add('(' + orClause.join(' OR ') + ')')
        }
        this
    }

    def and(Closure closure) {
        def andClause = []
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        if (andClause.size() > 0) {
            whereClause.add('(' + andClause.join(' AND ') + ')')
        }
        this
    }

    def eq(String column, Object value) {
        def paramName = "param_${params.size()}"
        if (value == null) {
            whereClause.add("${column} IS :${paramName}")
        } else {
            whereClause.add("${column} = :${paramName}")
        }
        params[paramName] = value
        this
    }

    def nonEq(String column, Object value) {
        def paramName = "param_${params.size()}"
        if (value == null) {
            whereClause.add("${column} IS NOT :${paramName}")
        } else {
            whereClause.add("${column} != :${paramName}")
        }
        params[paramName] = value
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
        sql.rows(query, params) { row ->
            println row
        }
    }
}
