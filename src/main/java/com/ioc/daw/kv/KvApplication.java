
package com.ioc.daw.kv;

/**
 *
 * @author Xavi
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication 
public class KvApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KvApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(KvApplication.class, args);
    }
    
    /*
     * Configuración del CORS, para los metodos especificados, con origen cualquiera y para las cabeceras especificadas
     * 
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                    @Override
                    public void addCorsMappings(CorsRegistry registry) {
                            registry.addMapping("/**")
                                    .allowedOrigins("*")
                                    .allowedMethods("GET","POST","HEAD","OPTIONS","PUT","DELETE")
                                    .exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Methods","Authorization");

                                    
                    }
            };
    }

}
