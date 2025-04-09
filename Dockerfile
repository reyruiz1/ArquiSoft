FROM openjdk:17-jdk-slim

EXPOSE 9090
COPY target/parcial-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]