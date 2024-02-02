FROM openjdk:17-jdk-slim
COPY /target/rest-service-*.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]