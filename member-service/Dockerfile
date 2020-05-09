FROM openjdk:8-jdk-alpine
EXPOSE 1113
COPY target/member-service.war member-service.war
CMD ["catalina.sh", "run"]

ENTRYPOINT ["java","-war","member-service.war"]