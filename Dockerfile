FROM amazoncorretto:11-alpine-jdk                                
MAINTAINER Nicolas                                               
COPY target/argentina-programa-0.0.1-SPAPSHOT.jar ap-app.jar     
ENTRYPOINT["java", "-jar", "/ap-app.jar"]                                                       
