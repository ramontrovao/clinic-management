FROM maven:3-eclipse-temurin-25 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn package -DskipTests -B

FROM eclipse-temurin:25-jre

COPY --from=build /app/target/*.jar application.jar

ENTRYPOINT ["java", "-jar", "/application.jar"]
