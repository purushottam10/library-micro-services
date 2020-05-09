FROM openjdk:8-jdk-alpine
EXPOSE 1111
COPY target/lib-service.war lib-service.war
CMD ["catalina.sh", "run"]

ENTRYPOINT ["java","-war","lib-service.war"]