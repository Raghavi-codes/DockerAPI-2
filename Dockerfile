# Use Java base image
FROM eclipse-temurin:17-jdk

# Copy jar file into container
COPY target/DockerAPI-2-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]