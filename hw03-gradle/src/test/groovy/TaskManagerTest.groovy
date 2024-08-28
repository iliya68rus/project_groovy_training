import model.Action
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

    @Test
    void editActionSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1")

        def task = taskManager.getTaskListByDay(base.toLocalDate()).get(0)
        task.setActionList(List.of(new Action(base, "ActionEdit")))

        def taskNew = taskManager.getTaskListByDay(base.toLocalDate()).get(0)
        Assertions.assertEquals("ActionEdit", taskNew.getActionList().get(0).getText())
    }

    @Test
    void getBusyTimeSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")
        def busyTime = taskManager.getBusyTimeByDay(base.toLocalDate())
        println busyTime
        Assertions.assertTrue(busyTime.contains("to"))
    }

    @Test
    void getCountTaskSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")

        Assertions.assertEquals(1, taskManager.getCountTaskByDay(base.toLocalDate()))
    }

    @Test
    void getCountSeveralTaskSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")
        taskManager.addTask(base.plusHours(4), base.plusHours(5), "Action4", "Action5", "Action6")

        Assertions.assertEquals(2, taskManager.getCountTaskByDay(base.toLocalDate()))
    }

    @Test
    void getCountSeveralTaskDifferentDatesSuccessfully() {
        taskManager.addTask(base, base.plusHours(3), "Action1", "Action2", "Action3")
        taskManager.addTask(base.plusDays(1), base.plusDays(1).plusHours(3), "Action1", "Action2", "Action3")

        Assertions.assertEquals(1, taskManager.getCountTaskByDay(base.toLocalDate()))
    }
}
