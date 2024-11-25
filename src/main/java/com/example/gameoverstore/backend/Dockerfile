# Stage 1: Build the application
FROM gradle:8.0.2-jdk17 as builder

# Set the working directory
WORKDIR /usr/src/app

# Copy Gradle build configuration
COPY build.gradle settings.gradle ./

# Copy Gradle wrapper files
COPY gradlew gradlew.bat ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Run the Gradle build to create the JAR file
RUN ./gradlew bootJar --no-daemon

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Define the JAR file location
ARG JAR_FILE=/usr/src/app/build/libs/*.jar

# Copy the JAR file from the builder stage
COPY --from=builder ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]
