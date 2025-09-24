FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/demo-greeting-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]