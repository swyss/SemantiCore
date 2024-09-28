# Build Stage
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Kopiere pom.xml und lade Abhängigkeiten
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Kopiere den Rest des Codes
COPY src ./src

# Baue die Anwendung
RUN mvn package -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Kopiere das gebaute JAR aus dem vorherigen Schritt
COPY --from=build /app/target/semanticore-0.0.1-SNAPSHOT.jar app.jar

# Exponiere Port 8080
EXPOSE 8080

# Starte die Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]
