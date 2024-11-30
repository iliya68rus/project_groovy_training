package todo

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller('/actions')
class ActionController {

    @Inject
    ActionService actionService

    @Get('/')
    List<Action> index() {
        actionService.list()
    }

    @Post('/')
    HttpResponse<Action> save(@Body Action action) {
        actionService.save(action)
        HttpResponse.created(action)
    }
}
