FROM openjdk:8-jdk-alpine
EXPOSE 1112
COPY target/library-db.war library-db.war
ENTRYPOINT ["java","-jar","library-db.war"]