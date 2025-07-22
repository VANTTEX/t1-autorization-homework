FROM openjdk:17-jre-alpine

COPY target/t1-autorization-homework.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]