import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoSettings

import java.time.LocalDate
import java.time.LocalDateTime

@MockitoSettings
class TaskManagerTest {
    @InjectMocks
    private TaskManager taskManager;

    @Test
    void test1() {
        def now = LocalDateTime.now()

        taskManager.addTask(now, now.plusHours(3), "Action1", "Action2", "Action3")
        Assertions.assertEquals(1, taskManager.getTaskListByDay(LocalDate.now()).size())
    }
}
