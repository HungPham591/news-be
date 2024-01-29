## Use an official OpenJDK runtime as a parent image
#FROM openjdk:17
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the JAR file into the container at /app\
#COPY target/news-0.0.1-SNAPSHOT.jar /app/
#
## Specify the command to run on container startup
#CMD ["java", "-jar", "news-0.0.1-SNAPSHOT.jar"]

# Stage 1: Build the application JAR
FROM maven:3.9.6-eclipse-temurin-11-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/news-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "news-0.0.1-SNAPSHOT.jar"]