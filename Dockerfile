FROM openjdk:21-jdk-alpine
VOLUME /tmp
COPY target/task-management-system-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]