FROM openjdk:8-jdk-alpine
EXPOSE 1113
WORKDIR  /usr/library
ADD target/member-service.war  /usr/library/member-service.war
ENTRYPOINT ["java","-jar","member-service.war"]