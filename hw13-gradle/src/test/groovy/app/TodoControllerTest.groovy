package app

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

import static org.hamcrest.Matchers.equalTo

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTest {
    @LocalServerPort
    private Integer port

    @BeforeEach
    void setUp() {
        RestAssured.port = port
    }

    @Test
    void testCreateTodo() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Задача 1\",\"desc\":\"Описание задачи 1\"}")
                .when()
                .post("/api/todos")
                .then()
                .statusCode(200)
                .body("title", equalTo("Задача 1"))
                .body("desc", equalTo("Описание задачи 1"))
    }

    @Test
    void testGetAllTodos() {
        RestAssured.given()
                .when()
                .get("/api/todos")
                .then()
                .statusCode(200)
    }

    @Test
    void testGetTodoById() {
        Long id = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Задача 1\",\"desc\":\"Описание задачи 1\"}")
                .when()
                .post("/api/todos")
                .then()
                .extract()
                .path("id")

        RestAssured.given()
                .when()
                .get("/api/todos/${id}")
                .then()
                .statusCode(200)
                .body("title", equalTo("Задача 1"))
    }

    @Test
    void testUpdateTodo() {
        Long id = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Задача 1\",\"desc\":\"Описание задачи 1\"}")
                .when()
                .post("/api/todos")
                .then()
                .extract()
                .path("id")

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Задача 1 обновлена\",\"desc\":\"Описание задачи 1 обновлено\"}")
                .when()
                .put("/api/todos/${id}")
                .then()
                .statusCode(200)
                .body("title", equalTo("Задача 1 обновлена"))
                .body("desc", equalTo("Описание задачи 1 обновлено"))
    }

    @Test
    void testDeleteTodo() {
        Long id = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Задача 1\",\"desc\":\"Описание задачи 1\"}")
                .when()
                .post("/api/todos")
                .then()
                .extract()
                .path("id")

        RestAssured.given()
                .when()
                .delete("/api/todos/${id}")
                .then()
                .statusCode(200)
    }
}
