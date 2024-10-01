# Build Stage
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build

# Set working directory inside the container
WORKDIR /app

# Copy the Maven configuration file (pom.xml) and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Build the application, skipping tests
RUN mvn package -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jdk

# Set working directory for the runtime container
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/semanticore.jar app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the entry point to start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
