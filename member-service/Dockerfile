FROM openjdk:8-jdk-alpine
EXPOSE 1113
COPY target/member-service.war member-service.war
ENTRYPOINT ["java","-jar","member-service.war"]