import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoSettings

import java.time.LocalDateTime

@MockitoSettings
class TaskManagerTest {
    public static final LocalDateTime base = LocalDateTime.of(2024, 8, 25, 9, 0)
    @InjectMocks
    private TaskManager taskManager;

    @Test
    void addTaskSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")

        Assertions.assertEquals(1, taskManager.getTaskListByDay(base.toLocalDate()).size())
    }

    @Test
    void addTaskErrorAfterDay() {
        Assertions.assertThrows(RuntimeException.class, () -> taskManager.addTask(base, base.minusDays(3), "Action1"))
    }

    @Test
    void addSeveralTaskSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")
        taskManager.addTask(base.plusHours(6), base.plusHours(7), "Action4", "Action5", "Action6")

        Assertions.assertEquals(2, taskManager.getTaskListByDay(base.toLocalDate()).size())
    }

    @Test
    void addSeveralTaskErrorCrossing() {
        taskManager.addTask(base, base.plusHours(3), "Action1")

        Assertions.assertThrows(RuntimeException.class, () -> taskManager.addTask(base.plusHours(2), base.plusHours(7), "Action2"))
    }

    @Test
    void addSeveralTaskDifferentDatesSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")
        taskManager.addTask(base.plusDays(1), base.plusDays(1).plusHours(3), "Action1", "Action2", "Action3")

        Assertions.assertEquals(1, taskManager.getTaskListByDay(base.toLocalDate()).size())
    }
}
