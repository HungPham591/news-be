## Use an official OpenJDK runtime as a parent image
#FROM openjdk:17
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the JAR file into the container at /app
#COPY target/news-0.0.1-SNAPSHOT.jar /app/
#
## Specify the command to run on container startup
#CMD ["java", "-jar", "news-0.0.1-SNAPSHOT.jar"]

# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Create a smaller image with only the JAR file
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/your-spring-boot-app.jar /app/
CMD ["java", "-jar", "your-spring-boot-app.jar"]