import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConfigBuilderTest {

    @Test
    void testDefaultConfig() {
        def store = ConfigBuilder.build()

        Assertions.assertEquals("MyTest", store.name)
        Assertions.assertEquals("Apache Tomcat", store.description)
        Assertions.assertEquals(8080, store.httpPort)
        Assertions.assertEquals(false, store.httpSecurity)
        Assertions.assertEquals(4443, store.httpsPort)
        Assertions.assertEquals(true, store.httpsSecurity)

        Assertions.assertEquals(true, store.mapping.get("/"))
        Assertions.assertEquals(false, store.mapping.get("/login"))
    }


    @Test
    void testTestConfig() {
        def store = ConfigBuilder.build("test.conf")

        Assertions.assertEquals("MyTest", store.name)
        Assertions.assertEquals("Apache Tomcat", store.description)
        Assertions.assertEquals(8081, store.httpPort)
        Assertions.assertEquals(false, store.httpSecurity)
        Assertions.assertEquals(4443, store.httpsPort)
        Assertions.assertEquals(true, store.httpsSecurity)

        Assertions.assertEquals(true, store.mapping.get("/"))
        Assertions.assertEquals(false, store.mapping.get("/login"))
    }

    @Test
    void testDevConfig() {
        def store = ConfigBuilder.build("dev.conf")

        Assertions.assertEquals("MyTest", store.name)
        Assertions.assertEquals("Apache Tomcat", store.description)
        Assertions.assertEquals(8080, store.httpPort)
        Assertions.assertEquals(false, store.httpSecurity)
        Assertions.assertEquals(4443, store.httpsPort)
        Assertions.assertEquals(true, store.httpsSecurity)

        Assertions.assertEquals(true, store.mapping.get("/"))
        Assertions.assertEquals(false, store.mapping.get("/login"))
    }

    @Test
    void testProdConfig() {
        def store = ConfigBuilder.build("prod.conf")

        Assertions.assertEquals("MyTest", store.name)
        Assertions.assertEquals("Apache Tomcat", store.description)
        Assertions.assertEquals(80, store.httpPort)
        Assertions.assertEquals(false, store.httpSecurity)
        Assertions.assertEquals(443, store.httpsPort)
        Assertions.assertEquals(true, store.httpsSecurity)

        Assertions.assertEquals(true, store.mapping.get("/"))
        Assertions.assertEquals(false, store.mapping.get("/login"))
    }
}
