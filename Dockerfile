# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the host machine to the container
COPY target/questionmicro-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on server.port
EXPOSE 8081

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
