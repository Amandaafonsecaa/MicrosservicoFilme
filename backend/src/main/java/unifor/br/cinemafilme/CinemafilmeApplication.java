package unifor.br.cinemafilme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class CinemafilmeApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(CinemafilmeApplication.class, args);
        
        try {
            MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
            mongoTemplate.getDb().getName(); // Testa a conexão
            System.out.println("Conectado ao MongoDB - Banco: " + mongoTemplate.getDb().getName());
        } catch (Exception e) {
            System.err.println("Não conectado ao MongoDB: " + e.getMessage());
        }
    }

}