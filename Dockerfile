FROM openjdk:17-jdk-alpine3.14

COPY "./target/jegyzeteim.jar" "/application/jegyzeteim.jar"

CMD ["java", "-jar", "/application/jegyzeteim.jar"]