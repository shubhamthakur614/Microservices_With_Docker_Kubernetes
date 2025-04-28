#start with a base image containg java runtime
FROM openjdk:17-jdk-slim

#inforamtion around who maintains the image
MAINTAINER shubham thakur

#add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]



