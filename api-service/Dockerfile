FROM eclipse-temurin:17-jdk-alpine

COPY target/api-service-0.0.1-SNAPSHOT.jar api-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/api-service.jar"]