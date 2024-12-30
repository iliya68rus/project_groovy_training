package service

import fluent.FluentTestSpec
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MyService2Test {
    @Test
    void testFullName() {
        FluentTestSpec
                .given {
                    mocks "mock1", "mock2"
                    target MyService2
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

    @Test
    void testType() {
        def audit = Mockito.mock(Audit)
        Mockito.when(audit.getType()).thenReturn("MyValue")

        FluentTestSpec
                .given {
                    mocks audit, "mock1", "mock2"
                    target MyService2
                }
                .when {
                    callMethod {
                        it.getTypeAudit()
                    }
                }
                .then {
                    assertEq("MyValue")
                }
    }
}
