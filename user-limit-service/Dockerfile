FROM openjdk:8-jdk-alpine
EXPOSE 1114
COPY target/user-limit-service.war user-limit-service.war
ENTRYPOINT ["java","-jar","user-limit-service.war"]