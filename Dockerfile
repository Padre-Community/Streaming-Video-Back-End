FROM maven:3.9.15-eclipse-temurin-21-alpine AS builder

ADD /src /app/src

ADD /pom.xml /app

RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:21-jre-alpine AS runtime

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

USER appuser

WORKDIR /usr/src/app

COPY --from=builder /app/target/*.jar video-max.jar

EXPOSE 8080

LABEL key="app.video-max"

ENTRYPOINT ["java", "-jar", "video-max.jar"]