FROM openjdk:17

WORKDIR /app

COPY build/libs/hw12-gradle-1.0-SNAPSHOT.jar /app/todo-list.jar

ENTRYPOINT ["java", "-jar", "/app/todo-list.jar"]
