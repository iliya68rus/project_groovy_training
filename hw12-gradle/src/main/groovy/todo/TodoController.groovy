package todo

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller('/todos')
class TodoController {

    @Inject
    TodoService todoService

    @Get('/')
    List<Todo> index() {
        todoService.list()
    }

    @Post('/')
    HttpResponse<Todo> save(@Body Todo todo) {
        todoService.save(todo)
        HttpResponse.created(todo)
    }
}
