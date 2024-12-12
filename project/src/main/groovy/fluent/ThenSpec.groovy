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

    def assertEq(String expected) {
        Assertions.assertEquals(expected, (String) result, "Ожидаемый результат $expected но получен $result")
    }

    def assertEq(def expected) {
        //noinspection GroovyAssignabilityCheck
        Assertions.assertEquals(expected, result, "Ожидаемый результат $expected но получен $result")
    }

    def assertEq(def expected, Closure closure) {
        if (expected instanceof GString) {
            expected = expected.toString()
        }
        Assertions.assertEquals(expected, closure(result), "Ожидаемый результат $expected но получен ${closure(result)}")
    }

    def assertFalse() {
        Assertions.assertFalse((boolean) result, "Ожидаемый результат false но получен $result")
    }

    def assertTrue() {
        Assertions.assertTrue((boolean) result, "Ожидаемый результат true но получен $result")
    }
}
