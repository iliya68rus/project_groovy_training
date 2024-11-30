package todo

import grails.gorm.services.Service

@Service(Todo)
interface TodoService {
    List<Todo> list()
    Todo save(Todo todo)
}
