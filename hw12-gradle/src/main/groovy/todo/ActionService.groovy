package todo

import grails.gorm.services.Service

@Service(Action)
interface ActionService {
    List<Action> list()
    Action save(Action action)
}