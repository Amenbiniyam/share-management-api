FROM maven AS maven
LABEL MAINTAINER="BINIYAM"
# Create a folder called 'app' and move to that folder
WORKDIR /usr/src/app
# copy everything in this directory to 'app'
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

# Cached Local eclipse-temurin image
FROM eclipse-temurin:latest
ARG JAR_FILE=share-management-api.jar
WORKDIR /opt/app
# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","share-management-api.jar"]
EXPOSE 8080

