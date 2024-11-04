package todo.list

class UrlMappings {
    static mappings = {
        "/"(controller: "todo", action: "index")
        "/todo"(resources: "todo")
    }
}
