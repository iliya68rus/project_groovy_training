import org.junit.jupiter.api.Test

class MyServiceTest {
//    MyService myService

    @Test
    void testDoSomething() {
        MyService myService = new MyService()
        FluentTestSpec
                .given {
                    target myService
                }
                .when {
                    callMethod {
                        myService.doSomething(50)
                    }
                }
                .then {
                    assertNotNull()
                    assertEq(100)
                }
    }

    @Test
    void testIsEven() {
        MyService myService = new MyService()
        FluentTestSpec
                .given {
                    target myService
                }
                .when {
                    callMethod {
                        myService.isEven(5)
                    }
                }
                .then {
                    assertFalse()
                }
    }
}
