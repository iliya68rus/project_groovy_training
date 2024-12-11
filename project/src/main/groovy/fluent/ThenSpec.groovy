package fluent

import org.junit.jupiter.api.Assertions

class ThenSpec {
    def result

    ThenSpec(def result) {
        this.result = result
    }

    def assertNotNull() {
        Assertions.assertNotNull(result, "Ожидаемое значение не должно быть равно null")
    }

    def assertEq(expected) {
        //noinspection GroovyAssignabilityCheck
        Assertions.assertEquals(expected, result, "Ожидаемый результат $expected но получен $result")
    }

    def assertFalse() {
        //noinspection GroovyAssignabilityCheck
        Assertions.assertFalse(result, "Ожидаемый результат false но получен $result")
    }

    def assertTrue() {
        //noinspection GroovyAssignabilityCheck
        Assertions.assertTrue(result, "Ожидаемый результат true но получен $result")
    }
}
