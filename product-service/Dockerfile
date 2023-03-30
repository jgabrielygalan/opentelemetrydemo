FROM eclipse-temurin:17-jdk-alpine

COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/product-service.jar"]