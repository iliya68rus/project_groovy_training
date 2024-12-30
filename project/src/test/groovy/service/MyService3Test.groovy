package service

import fluent.FluentTestSpec
import model.PersonModel
import org.junit.jupiter.api.Test

class MyService3Test {
    @Test
    void testData() {
        FluentTestSpec
                .given {
                    target MyService3
                }
                .when {
                    callMethod {
                        it.getData()
                    }
                }
                .then {
                    assertEq("fieldValue1") {
                        it.getField1()
                    }
                }
    }

    @Test
    void testPerson() {
        def person = new PersonModel(firstName: "Илья", lastName: "Павлович")

        FluentTestSpec
                .given {
                    target MyService3
                }
                .when {
                    callMethod {
                        it.convertPerson(person)
                    }
                }
                .then {
                    assertEq("${person.getFirstName()} ${person.getLastName()}") {
                        it.getFullName()
                    }
                }
    }
}
