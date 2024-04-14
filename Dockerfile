FROM maven:3-openjdk-11
COPY . .
RUN mvn clean install
CMD ["java","-jar","target/demo-1.0.0.jar"]