package service

import model.DataModel
import model.PersonModel
import model.PersonResponse

class MyService3 {
    private final Audit audit

    MyService3(Audit audit) {
        this.audit = audit
    }

    def getData() {
        audit.log("лог 1")
        audit.log("лог 2")
        new DataModel("fieldValue1", "fieldValue2")
    }

    def convertPerson(PersonModel person) {
        new PersonResponse("${person.getFirstName()} ${person.getLastName()}")
    }
}
