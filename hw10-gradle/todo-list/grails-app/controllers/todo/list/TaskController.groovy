package todo.list


class TaskController {

    static responseFormats = ['json', 'xml']

    def index() {
        respond Task.list()
    }

    def show(Long id) {
        respond Task.get(id) ?: respond(status: NOT_FOUND)
    }

    def create() {
        respond new Task(params)
    }

    def save(Task task) {
        if (task.save(flush: true)) {
            respond task, [status: CREATED]
        } else {
            respond task.errors, [status: NOT_ACCEPTABLE]
        }
    }

    def update(Task task) {
        if (task.save(flush: true)) {
            respond task, [status: OK]
        } else {
            respond task.errors, [status: NOT_ACCEPTABLE]
        }
    }

    def delete(Long id) {
        Todo.get(id)?.delete(flush: true)
        respond status: NO_CONTENT
    }
}