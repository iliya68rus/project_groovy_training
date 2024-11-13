import groovy.sql.Sql
import model.Cat

def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/postgres',
        'postgres', 'postgres', 'org.postgresql.Driver')
sql.execute('DROP TABLE IF EXISTS cat')
sql.execute('CREATE TABLE cat (name VARCHAR, age INT)')
sql.execute('INSERT INTO cat (name, age) VALUES (\'Барсик\', 4)')
sql.execute('INSERT INTO cat (name, age) VALUES (\'Леший\', NULL)')

def query = new QueryBuilder(sql, Cat)
query.from(Cat).where {
    or {
        "age".eq(4)
        "age".nonEq(null)
    }
}.execute()
