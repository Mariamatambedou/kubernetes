# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Installer curl pour effectuer des requêtes HTTP
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré par le build
COPY target/demo-enset-student-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port que l'application utilise
EXPOSE 8021

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

