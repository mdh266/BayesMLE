FROM openjdk:8-jre-alpine3.9
RUN mkdir /app
COPY ../target/poisson-1.0-jar-with-dependencies.jar /app
WORKDIR /app
EXPOSE 25333
CMD ["java", "-jar", "poisson-1.0-jar-with-dependencies.jar", "/app.war"]