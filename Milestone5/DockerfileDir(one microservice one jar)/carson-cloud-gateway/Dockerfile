FROM alpine
VOLUME /fsd
ADD carson-cloud-gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]
EXPOSE 8080