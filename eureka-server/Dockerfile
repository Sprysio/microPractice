FROM maven:3.9.7-sapmachine-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline || mvn dependency:resolve

COPY /src ./src

RUN mvn -f pom.xml clean package -DskipTests

#FROM eclipse-temurin:17-jre-alpine
FROM openjdk:21-jdk-slim
     
WORKDIR /app

RUN apt-get update && \
    apt-get install -y curl dumb-init && \
    groupadd --system javauser && \
    useradd -s /bin/false -g javauser javauser && \
    rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/*.jar app.jar

RUN chown -R javauser:javauser /app

USER javauser

EXPOSE 8761

CMD ["dumb-init", "java", "-jar", "app.jar"]