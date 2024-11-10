# Étape 1 : Utiliser une image de base Nginx pour servir l'application Angular
FROM nginx:alpine

# Copier les fichiers Angular buildés depuis le répertoire dist dans le répertoire de Nginx
COPY ./frontend-angular/dist/frontend-ang-app/browser/ /usr/share/nginx/html

# Exposer le port que Nginx utilise
EXPOSE 80

# Commande pour démarrer Nginx
CMD ["nginx", "-g", "daemon off;"]


