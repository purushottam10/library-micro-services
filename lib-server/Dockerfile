FROM openjdk:8-jdk-alpine
EXPOSE 1111
COPY target/lib-server.war lib-server.war
ENTRYPOINT ["java","-jar","lib-server.war"]