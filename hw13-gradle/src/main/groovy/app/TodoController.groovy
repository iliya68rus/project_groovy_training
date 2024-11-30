package app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('/api/todos')
class TodoController {

    @Autowired
    TodoRepository todoRepository

    @GetMapping
    List<Todo> getAllTodos() {
        return todoRepository.findAll()
    }

    @PostMapping
    Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo)
    }

    @GetMapping('/{id}')
    ResponseEntity<Todo> getTodoById(@PathVariable(name = "id") Long id) {
        return todoRepository.findById(id)
                .map { todo -> ResponseEntity.ok(todo) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping('/{id}')
    ResponseEntity<Todo> updateTodo(@PathVariable(name = "id") Long id, @RequestBody Todo todoDetails) {
        return todoRepository.findById(id)
                .map { todo ->
                    todo.title = todoDetails.title
                    todo.desc = todoDetails.desc
                    ResponseEntity.ok(todoRepository.save(todo))
                }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping('/{id}')
    ResponseEntity<Void> deleteTodo(@PathVariable(name = "id") Long id) {
        return todoRepository.findById(id)
                .map { todo ->
                    todoRepository.delete(todo)
                    ResponseEntity.ok().<Void>build()
                }.orElse(ResponseEntity.notFound().build())
    }
}