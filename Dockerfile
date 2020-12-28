FROM openjdk:8-jdk-alpine
LABEL responsable="o.barberis@outlook.fr"
EXPOSE 8045:8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patient.jar
ENTRYPOINT ["java","-jar","/patient.jar"]