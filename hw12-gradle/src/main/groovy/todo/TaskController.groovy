package todo

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller('/tasks')
class TaskController {

    @Inject
    TaskService taskService

    @Get('/')
    List<Task> index() {
        taskService.list()
    }

    @Post('/')
    HttpResponse<Task> save(@Body Task task) {
        taskService.save(task)
        HttpResponse.created(task)
    }
}
