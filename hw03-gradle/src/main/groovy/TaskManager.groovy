import model.Task

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.stream.Collectors

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
        return taskList.groupBy { it.start.toLocalDate() }.get(date, Collections.emptyList())
    }

    String getBusyTimeByDay(LocalDate date) {
        return taskList.groupBy { it.start.toLocalDate() }
                .get(date, Collections.emptyList())
                .stream()
                .map(e -> "from " + e.start.toString() + " to " + e.end.toString() + " actions=[" + e.getActionList()
                        .stream()
                        .map(a -> a.getText())
                        .collect(Collectors.joining(",")) + "]")
                .collect(Collectors.joining("\n"))
    }

    int getCountTaskByDay(LocalDate date) {
        return getTaskListByDay(date).size()
    }

    private static boolean between(LocalDateTime start, LocalDateTime end, LocalDateTime current) {
        return (current.isEqual(start) || current.isAfter(start)) &&
                (current.isEqual(end) || current.isBefore(end))
    }
}
