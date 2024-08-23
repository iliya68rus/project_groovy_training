import model.Task

import java.time.LocalDate
import java.time.LocalDateTime

class TaskManager {
    private final List<Task> taskList = new ArrayList<>()

    void addTask(LocalDateTime start, LocalDateTime end, String... actions) {
        def task = new Task(start, end, actions)
        taskList.add(task)
    }

    List<Task> getTaskListByDay(LocalDate date) {
        return taskList
    }
}
