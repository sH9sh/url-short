#FROM maven:3.8.5-openjdk-17-slim
#WORKDIR /url-short
#COPY src     /url-short/src
#COPY pom.xml /url-short
#RUN mvn clean package
#
#FROM openjdk:17-jdk-alpine
#COPY --from=0 /url-short/target/Url-Shortener-0.0.1-SNAPSHOT.jar  /app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM maven:3.9.6 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17.0.11_9-jre-focal
COPY --from=builder /app/target//Url-Shortener-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]