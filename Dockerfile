FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE=target/widget.jar
COPY ${JAR_FILE} widget.jar
COPY src/main/resources/keycloak.json keycloak.json
RUN bash -c "touch /widget.jar"
EXPOSE 8086
ENTRYPOINT ["java","-jar","widget.jar"]