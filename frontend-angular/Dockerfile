# Étape 1 : Construire l'application Angular
# Utiliser une image de base Node.js pour le build
FROM node:16 as build

# Définir le répertoire de travail pour le build Angular
WORKDIR /app

# Copier les fichiers du projet dans le conteneur
COPY . .

# Installer les dépendances et builder l'application Angular en production
RUN npm install
RUN npm run build --prod

# Étape 2 : Utiliser une image de base Nginx pour servir l'application Angular
FROM nginx:alpine

# Copier les fichiers Angular buildés depuis l'étape de build dans le répertoire de Nginx
COPY --from=build /app/dist/frontend-angular /usr/share/nginx/html

# Exposer le port que Nginx utilise
EXPOSE 80

# Commande pour démarrer Nginx
CMD ["nginx", "-g", "daemon off;"]

