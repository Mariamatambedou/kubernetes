package com.example.demoensetstudent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Autoriser les requêtes CORS venant de "k8s.local"
        registry.addMapping("/**")  // Applique CORS à toutes les routes de l'API backend
            .allowedOrigins("http://k8s.local")  // C'est l'URL du frontend (dépend de votre Ingress ou service exposé)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes HTTP autorisées
            .allowedHeaders("*")  // Autorise tous les en-têtes
            .allowCredentials(true);  // Si nécessaire, autorise l'envoi de cookies
    }
}

