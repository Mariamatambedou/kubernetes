# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré par le build
COPY target/demo-enset-student-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port que l'application utilise
EXPOSE 8021

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
