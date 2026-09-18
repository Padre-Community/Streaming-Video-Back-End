FROM maven:3.9.15-eclipse-temurin-21-alpine AS builder

ADD /src /app/src

ADD /pom.xml /app

RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM alpine:3.24.1 AS runtime

RUN apk update

RUN apk add openjdk21-jre

RUN apk update && apk upgrade --no-cache

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

USER streamxuser

LABEL key="app.stream-x"

WORKDIR /usr/src/app

COPY --from=builder /app/target/*.jar stream-x.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "stream-x.jar"]