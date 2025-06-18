FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /build
COPY server/pom.xml .
COPY server/src/ src/
COPY server/api/ api/
RUN ["mvn", "-ntp", "clean", "compile", "package", "-DskipTests"]

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /build/target/*.jar prost.jar
CMD ["java", "-jar", "prost.jar"]
