FROM openjdk:17
EXPOSE 8888
COPY build/libs/Equus-Config-Server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
