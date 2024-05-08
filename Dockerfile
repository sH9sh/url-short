FROM maven:3.8.5-openjdk-17-slim
WORKDIR /url-short
COPY src     /url-short/src
COPY pom.xml /url-short
RUN mvn clean package

FROM openjdk:17-jdk-alpine
COPY --from=0 /url-short/target/Url-Shortener-0.0.1-SNAPSHOT.jar  /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]