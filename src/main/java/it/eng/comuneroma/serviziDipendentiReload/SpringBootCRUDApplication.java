package it.eng.comuneroma.serviziDipendentiReload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import it.eng.comuneroma.serviziDipendentiReload.configuration.JpaConfiguration;

@SpringBootApplication
@Import(JpaConfiguration.class)
public class SpringBootCRUDApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCRUDApplication.class, args);
    }
}
