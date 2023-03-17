FROM amazoncorretto:11-alpine-jdk
MAINTAINER Nicolas
COPY target/argentina-programa-0.0.1-SNAPSHOT.jar  argentina-programa.jar
ENTRYPOINT ["java","-jar","/argentina-programa.jar"]