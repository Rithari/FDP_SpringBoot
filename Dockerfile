# Use Maven base image to build the project
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copy the project files
COPY ./pom.xml .
COPY ./src ./src

# Build the application
RUN mvn -B -f pom.xml clean package -DskipTests

# Use OpenJDK for the final image
FROM openjdk:21-jdk

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
