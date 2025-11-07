FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY target/mcsv-datawarehouse.jar /app/mcsv-datawarehouse.jar

EXPOSE 8087

ENTRYPOINT ["java", "-jar", "mcsv-datawarehouse.jar"]


