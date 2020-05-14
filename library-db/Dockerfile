FROM openjdk:8-jdk-alpine
EXPOSE 1112
WORKDIR /usr/library
ADD target/library-db.war /usr/library/library-db.war
ENTRYPOINT ["java","-jar","library-db.war"]