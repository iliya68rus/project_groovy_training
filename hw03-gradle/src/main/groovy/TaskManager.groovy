import model.Task

import java.time.LocalDate
import java.time.LocalDateTime

class TaskManager {
    private final List<Task> taskList = new ArrayList<>()

    void addTask(LocalDateTime start, LocalDateTime end, String... actions) {
        if (start == end || start.isAfter(end)) {
            throw new RuntimeException("Неправильно заполнены даты")
        }
        taskList.forEach(e -> {
            if (between(e.getStart(), e.getEnd(), start) || between(e.getStart(), e.getEnd(), end)) {
                throw new RuntimeException("Дата пересекается с другими задачами")
            }
        })

        def task = new Task(start, end, actions)
        taskList.add(task)
    }

    List<Task> getTaskListByDay(LocalDate date) {
        return taskList
    }

    static boolean between(LocalDateTime start, LocalDateTime end, LocalDateTime current) {
        return (current.isEqual(start) || current.isAfter(start)) &&
                (current.isEqual(end) || current.isBefore(end))
    }
}
