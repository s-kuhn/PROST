FROM maven:3.9.9-eclipse-temurin-23 AS build
WORKDIR /build
COPY server/pom.xml .
COPY server/src/ src/
RUN ["mvn", "-ntp -DskipTests", "clean package"]

FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /build/target/*.jar prost.jar
CMD ["java", "-jar", "prost.jar"]
