package todo.list

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TaskSpec extends Specification implements DomainUnitTest<Task> {

     void "test domain constraints"() {
        when:
        Task domain = new Task()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
