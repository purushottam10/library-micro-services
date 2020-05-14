FROM openjdk:8-jdk-alpine
EXPOSE 1111
WORKDIR  /usr/library
ADD target/lib-server.war  /usr/library/lib-server.war
ENTRYPOINT ["java","-jar","lib-server.war"]