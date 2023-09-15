# Use a Maven-based image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project definition and fetch the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the Spring Boot application
RUN mvn package -DskipTests

# Use the official OpenJDK base image for Java to create the final image
FROM maven:3.8.4-openjdk-17 as final

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar .

# Expose the port your Spring Boot application listens on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
