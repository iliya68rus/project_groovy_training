package todo.list

class UrlMappings {
    static mappings = {
        "/"(controller: "todo", action: "index")
        "/todo"(resources: "todo")

        "/api/tasks"(controller: "task", parseRequest: true) {
            action = [GET: "index", POST: "save"]
        }

        "/api/tasks/$id"(controller: "task", parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete"]
        }
    }
}
