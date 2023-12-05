FROM eclipse-temurin:21
WORKDIR /App
COPY target/boulanger*.jar ./boulangerApi-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "boulangerApi-0.0.1-SNAPSHOT.jar"]