FROM openjdk:17
RUN echo "hello docker file"
WORKDIR application
ARG JAR_FILE=sbp-cit/libs/sbp-cit.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["sh","-c","java","-jar","application.jar"]