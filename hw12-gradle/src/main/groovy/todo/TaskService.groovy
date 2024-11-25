package todo

import grails.gorm.services.Service

@Service(Task)
interface TaskService {
    List<Task> list()
    Task save(Task task)
}