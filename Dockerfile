FROM openjdk

WORKDIR /app

COPY target/task-list-0.0.1-SNAPSHOT.jar /app/server-release-1.0.jar

ENTRYPOINT ["java", "-jar", "server-release-1.0.jar"]