FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

ADD pom.xml /app/.
RUN ["mvn", "clean", "--fail-never"]

COPY . /app/.
RUN --mount=type=cache,target=/root/.m mvn -f /app/pom.xml package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/*.jar"]