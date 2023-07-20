FROM openjdk:17
ARG JAR_FILE=target/myspring*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/app.jar"]
