package todo.list

class Task {
    String title
    String description
    Boolean completed = false
    LocalDate startDate
    LocalDate endDate

    static constraints = {
        title nullable: false, blank: false
        description nullable: true
        startDate nullable: true
        endDate nullable: true
    }
}