FROM eclipse-temurin:17-jre-alpine

COPY target/t1-autorization-homework-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]