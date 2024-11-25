package todo

import grails.gorm.annotation.Entity

import java.time.LocalDate

@Entity
class Action {
    String description
    LocalDate startDate
    LocalDate endDate
}