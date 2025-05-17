package study_rest_with_spring_boot_and_java.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study_rest_with_spring_boot_and_java.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

// Esta anotação indica que esta classe é um controlador REST.
// Ou seja, ela vai receber e responder requisições HTTP no formato JSON.
@RestController
public class GreetingController {

    // Template da mensagem de saudação. "%s" será substituído pelo nome.
    private static final String template = "Hello, %s!";

    // Variável usada para gerar um ID diferente a cada requisição.
    // AtomicLong é usado porque é seguro para múltiplas threads.
    private final AtomicLong counter = new AtomicLong();

    // Este método será chamado quando o navegador acessar /greeting
    // Exemplo: http://localhost:8080/greeting?name=Alex
    @RequestMapping("/greeting")
    public Greeting greeting(
            // Este parâmetro captura o valor passado na URL como "?name=Alex"
            // Se o nome não for informado, o valor padrão será "Word"
            @RequestParam(value = "name", defaultValue = "Word") String name) {

        // Retorna um novo objeto Greeting com:
        // - um ID incremental
        // - uma mensagem personalizada ("Hello, Alex!")
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
