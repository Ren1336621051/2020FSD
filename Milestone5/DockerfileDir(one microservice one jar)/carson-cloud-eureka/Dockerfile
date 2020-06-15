FROM alpine
VOLUME /fsd
ADD carson-cloud-eureka-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java","-jar","/eureka.jar"]
EXPOSE 8080