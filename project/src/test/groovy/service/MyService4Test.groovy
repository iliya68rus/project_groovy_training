package service

import fluent.FluentTestSpec
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MyService4Test {
    @Test
    void testTimes() {
        def audit = Mockito.mock(Audit)

        FluentTestSpec
                .given {
                    mocks audit
                    target MyService3
                }
                .when {
                    callMethod {
                        it.getData()
                    }
                }
                .then {
                    assertTimes(audit, 2) {
                        it.log(Mockito.any())
                    }
                    assertTimes(audit, 1) {
                        it.log("лог 1")
                    }
                    assertTimes(audit, 0) {
                        it.getType()
                    }
                }
    }
}
