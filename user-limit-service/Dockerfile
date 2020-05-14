FROM openjdk:8-jdk-alpine
EXPOSE 1114
WORKDIR  /usr/library
ADD target/user-limit-service.war  /usr/library/user-limit-service.war
ENTRYPOINT ["java","-jar","user-limit-service.war"]