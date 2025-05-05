#start with a base image containg java runtime
FROM openjdk:17-jdk-slim

#inforamtion around who maintains the image
LABEL maintainer="shubham thakur"

# Set the working directory (optional, but recommended)
WORKDIR /app

#add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on (optional, for documentation)
EXPOSE 8080

#execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]



