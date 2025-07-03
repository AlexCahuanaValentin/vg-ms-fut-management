package pe.edu.vallegrande.vg_ms_fut_management.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import com.mongodb.reactivestreams.client.MongoClients;  // Correcto: MongoClient reactivo
import org.springframework.data.mongodb.core.MongoTemplate; // Si usas MongoTemplate tradicional
import com.mongodb.reactivestreams.client.MongoClient;  // MongoClient reactivo para WebFlux

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Usamos MongoClients para la conexión reactiva a MongoDB Atlas
        return MongoClients.create("mongodb+srv://gradeadmin:8EmFywNWZN85pVhD@grades-cluster.oginegu.mongodb.net/fut_database?retryWrites=true&w=majority&tlsAllowInvalidHostnames=true&appName=fut-cluster");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        // Asegúrate de que ReactiveMongoTemplate esté usando MongoClient reactivo
        return new ReactiveMongoTemplate(mongoClient(), "fut_database");
    }
}



