FROM openjdk:8-jdk-alpine
EXPOSE 1112
COPY target/library_db.jar library-db.jar
CMD ["catalina.sh", "run"]

ENTRYPOINT ["java","-jar","library-db.jar"]