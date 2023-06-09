FROM openjdk:17
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar",  "-Dspring.profiles.active=dev", "-Dspring.datasource.url=${DATASOURCE_URL}", "-Dspring.datasource.username=${POSTGRES_USERNAME}", "-Dspring.datasource.password=${POSTGRES_PASSWORD}", "/app.jar"]