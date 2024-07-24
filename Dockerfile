FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY .mvn /app/.mvn
COPY mvnw /app/mvnw
COPY pom.xml /app/

RUN chmod +x /app/mvnw
RUN ./mvnw dependency:go-offline

COPY src /app/src

RUN chmod +x /app/mvnw
RUN ./mvnw clean package

FROM openjdk:17-jdk-slim
WORKDIR /app
## Copy the JAR file from the build directory to the container
COPY --from=build /app/target/interfaz-gestopago-1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]