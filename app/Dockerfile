#Use a imagem oficial do Maven, que ja inclui o JDK
FROM maven:3.9.7-amazoncorretto-17-debian

#Copie seu codigo fonte para o conteiner
COPY . /usr/src/app

#Defina o diretorio de trabalho
WORKDIR /usr/src/app

#Construa o projeto com Maven
RUN mvn clean install

#Exponha a porta que sua aplicação usa
EXPOSE 8080

#Comando para iniciar sua aplicação
CMD ["java", "-jar", "target/pessoa-1.0.0.jar"]