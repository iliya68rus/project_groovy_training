package todo.list

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class TaskControllerSpec extends Specification implements ControllerUnitTest<TaskController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
