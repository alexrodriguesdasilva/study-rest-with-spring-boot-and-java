package study_rest_with_spring_boot_and_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotação marca esta classe como o ponto de entrada da aplicação Spring Boot.
// Ela ativa várias configurações automáticas.
@SpringBootApplication
public class Startup {

	// O método principal (main) é o ponto de partida da aplicação Java.
	// SpringApplication.run inicia a aplicação Spring Boot.
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}
}
