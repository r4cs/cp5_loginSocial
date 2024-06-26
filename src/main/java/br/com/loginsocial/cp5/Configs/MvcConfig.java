package br.com.loginsocial.cp5.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("home/homeNotSignedIn");
        registry.addViewController("/logout").setViewName("home/homeSignedIn");
//        registry.addViewController("/swagger").setViewName("redirect:/api/swagger-ui/index.html");
    }
}