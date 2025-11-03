# Step 1: Use an official JDK runtime as the base image
FROM eclipse-temurin:21-jdk

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the packaged JAR file from your local target directory
COPY target/*.jar app.jar

# Step 4: Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Step 5: Command to run your app
ENTRYPOINT ["java", "-jar", "app.jar"]
