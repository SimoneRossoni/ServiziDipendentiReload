package it.eng.comuneroma.ServiziDipendentiReload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import it.eng.comuneroma.ServiziDipendentiReload.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"it.eng.comuneroma.ServiziDipendentiReload"})
public class SpringBootCRUDApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCRUDApplication.class, args);
    }
}
