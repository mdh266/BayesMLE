FROM openjdk:8-jre-alpine3.9
RUN mkdir /app
COPY poisson-1.0-jar-with-dependencies.jar /app
EXPOSE 25333
CMD ["java", "-jar", "/app/poisson-1.0-jar-with-dependencies.jar"]