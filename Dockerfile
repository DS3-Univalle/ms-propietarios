# Etapa 1: Compilar el proyecto y generar el JAR
#FROM maven:3.8.4-openjdk-17-slim as build
#WORKDIR /build
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package

# Etapa 2: Crear la imagen final
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /build/target/proyecto-jpa-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
