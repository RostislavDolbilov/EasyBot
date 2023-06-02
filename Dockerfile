FROM openjdk:11
ADD target/easy-bot.jar easy-bot.jar
ENTRYPOINT ["java", "-jar","easy-bot.jar"]
EXPOSE 8080