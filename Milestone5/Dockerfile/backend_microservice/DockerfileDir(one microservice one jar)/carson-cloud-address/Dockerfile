FROM alpine
VOLUME /fsd
ADD carson-cloud-address-0.0.1-SNAPSHOT.jar address.jar
ENTRYPOINT ["java","-jar","/address.jar"]
EXPOSE 8080