package todo

import grails.gorm.annotation.Entity

@Entity
class Todo {
    String title
    String desc
}
