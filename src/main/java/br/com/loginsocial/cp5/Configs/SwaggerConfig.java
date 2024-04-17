package br.com.loginsocial.cp5.Configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI documentacao() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.description("Url de desenvolvimento local");

        Contact contact = new Contact();
        contact.setEmail("rm97373@fiap.com.br");
        contact.setName("Raquel");

        Info info = new Info().title("CP5 -> Digital Business Enablement")
                .version("0.1")
                .contact(contact)
                .description("CP5 DBE: spring security + login social + jpa");
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
