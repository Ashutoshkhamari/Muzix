FROM openjdk:11-jdk-stretch

ADD /target/MuzixApplication-0.0.1-SNAPSHOT.jar /src/main/MuzixApplication-0.0.1-SNAPSHOT.jar

WORKDIR /src/main

ENTRYPOINT ["java","-jar","MuzixApplication-0.0.1-SNAPSHOT.jar"]
