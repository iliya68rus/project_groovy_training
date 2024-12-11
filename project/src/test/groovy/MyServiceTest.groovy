import org.junit.jupiter.api.Test

class MyServiceTest {
    @Test
    void testDoSomething() {
        FluentTestSpec
                .given {
                    target MyService.class
                }
                .when {
                    callMethod {
                        it.doSomething(50)
                    }
                }
                .then {
                    assertNotNull()
                    assertEq(100)
                }
    }

    @Test
    void testIsEvenFalse() {
        FluentTestSpec
                .given {
                    target MyService.class
                }
                .when {
                    callMethod {
                        it.isEven(5)
                    }
                }
                .then {
                    assertFalse()
                }
    }

    @Test
    void testIsEvenTrue() {
        FluentTestSpec
                .given {
                    target MyService.class
                }
                .when {
                    callMethod {
                        it.isEven(6)
                    }
                }
                .then {
                    assertTrue()
                }
    }
}
