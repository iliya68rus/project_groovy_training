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
        Assertions.assertEquals(expected, result, "Ожидаемый результат $expected но получен $result")
    }

    def assertFalse() {
        Assertions.assertFalse(result, "Ожидаемый результат false но получен $result")
    }

    def assertTrue() {
        Assertions.assertTrue(result, "Ожидаемый результат true но получен $result")
    }
}
