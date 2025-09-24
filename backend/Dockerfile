FROM openjdk:17-jdk-slim

LABEL maintainer="your-email@example.com"


ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]