package todo

import grails.gorm.annotation.Entity

import java.time.LocalDateTime

@Entity
class Action {
    String description
    LocalDateTime startDate
    LocalDateTime endDate
}