package unifor.br.cinemafilme.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica CORS em todas as rotas
                .allowedOrigins("*") // aceita requisições de qualquer origem
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }   
}
