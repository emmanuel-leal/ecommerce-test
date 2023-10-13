FROM openjdk:11-jre-slim 
RUN addgroup --system spring && adduser --system spring --ingroup spring
VOLUME /tmp
EXPOSE 8082:8082
USER spring:spring
COPY --chown=spring /src/test/docker/wait-container.sh  /vol/component/wait-container.sh
RUN chmod -R 775 /vol/component/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
