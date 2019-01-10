FROM openjdk:8
ADD target/tax-exercise-handy.jar tax-exercise-handy.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar", "tax-exercise-handy.jar"]