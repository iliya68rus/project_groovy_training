package todo

import grails.gorm.annotation.Entity

@Entity
class Todo {
    String title
    String desc
    List<Task> tasks

    static hasMany = [tasks: Task]
}
