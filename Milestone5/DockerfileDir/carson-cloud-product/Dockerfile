FROM alpine
VOLUME /fsd
ADD carson-cloud-product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java","-jar","/product.jar"]
EXPOSE 8080