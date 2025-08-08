package lsmanut_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableAutoConfiguration
public class LsmanutencoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsmanutencoesApplication.class, args);
	}

}
