package service

import fluent.FluentTestSpec
import org.junit.jupiter.api.Test

class MyService2Test {
    @Test
    void testFullName() {
        FluentTestSpec
                .given {
                    mocks "mock1", "mock2"
                    target MyService2.class
                }
                .when {
                    callMethod {
                        it.getFullName("test")
                    }
                }
                .then {
                    assertEq("mock1 mock2 test")
                }
    }
}
