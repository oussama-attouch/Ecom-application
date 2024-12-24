package oss.att.inventoryservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

// Importe les classes nécessaires pour configurer la sécurité Spring et les CORS.
@Configuration
// Indique que cette classe est une classe de configuration Spring et qu'elle peut définir des beans.
@EnableWebSecurity
// Active la configuration de la sécurité Web de Spring.
public class SecurityConfig {
    @Bean
    // Déclare un bean pour le filtre de sécurité. Ce filtre définit les règles de sécurité de l'application.
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                // Active le support des CORS (Cross-Origin Resource Sharing) avec une configuration par défaut.
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Configure la gestion des sessions en mode stateless (sans session persistante).
                .csrf(csrf -> csrf.disable())
                // Désactive la protection CSRF (Cross-Site Request Forgery), utile pour les APIs REST stateless.
                .headers(h -> h.frameOptions(fo -> fo.disable()))
                // Désactive les options de frame pour permettre l'accès au contenu comme la console H2 (en développement uniquement).
                .authorizeHttpRequests(ar -> ar.requestMatchers("/h2-console/**").permitAll())
                // Permet l'accès public (sans authentification) aux URL commençant par "/api/**" et "/h2-console/**".
                .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
                // Exige une authentification pour toutes les autres requêtes.
                .oauth2ResourceServer(o2->o2.jwt(Customizer.withDefaults()))
                .build();
                // Construit et retourne l'objet SecurityFilterChain configuré.
    }

    @Bean
    // Déclare un bean pour la configuration des CORS.
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        // Autorise toutes les origines (peut être restreint en production pour des raisons de sécurité).
        configuration.setAllowedMethods(Arrays.asList("*"));
        // Autorise toutes les méthodes HTTP (GET, POST, PUT, DELETE, etc.).
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // Autorise tous les en-têtes HTTP (headers).
        configuration.setExposedHeaders(Arrays.asList("*"));
        // Expose tous les en-têtes pour qu'ils soient visibles dans les réponses.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        // Associe cette configuration à tous les chemins d'URL ("/**").
        return source;
        // Retourne l'objet configuré.
    }
}
