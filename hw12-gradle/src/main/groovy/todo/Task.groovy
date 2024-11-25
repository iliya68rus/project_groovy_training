package todo

import grails.gorm.annotation.Entity

@Entity
class Task {
    String description
    List<Action> actions

    static hasMany = [actions: Action]
}