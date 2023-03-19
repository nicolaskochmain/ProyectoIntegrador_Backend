FROM alpine:latest
MAINTAINER nicolas
COPY target/argentina-programa-0.0.1-SNAPSHOT.jar ap-app.jar
ENTRYPOINT ["java","-jar","/ap-app.jar"]
CMD ["/bin/sh"]
