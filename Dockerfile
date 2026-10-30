
FROM eclipse-temurin:21-jdk

WORKDIR /Myapp

COPY target/book_library_api-0.0.1-SNAPSHOT.jar Myapp.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "Myapp.jar"]