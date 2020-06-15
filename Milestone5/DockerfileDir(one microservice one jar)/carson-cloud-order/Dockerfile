FROM alpine
VOLUME /fsd
ADD carson-cloud-order-0.0.1-SNAPSHOT.jar order.jar
ENTRYPOINT ["java","-jar","/order.jar"]
EXPOSE 8080