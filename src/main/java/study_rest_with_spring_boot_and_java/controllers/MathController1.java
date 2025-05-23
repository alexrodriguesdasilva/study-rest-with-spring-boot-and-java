// Define o pacote onde esta classe está localizada.
// Isso ajuda a organizar o código em diferentes partes do projeto.
package study_rest_with_spring_boot_and_java.controllers;

// Importações necessárias do Spring para criar APIs REST
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Anotação que indica que esta classe é um controlador REST,
// ou seja, ela responde a requisições HTTP com dados (normalmente em JSON)
@RestController

// Define o caminho base (endpoint) que será usado nas requisições a este controlador
@RequestMapping("/math")
public class MathController1 {

    // Define um endpoint do tipo GET no caminho /math/sum/{numberOne}/{numberTwo}
    // Ele aceita dois parâmetros na URL: numberOne e numberTwo
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        // Verifica se ambos os parâmetros são numéricos válidos
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            // Se algum não for numérico, lança uma exceção
            throw new Exception("Por favor, forneça valores numéricos válidos.");
        }

        // Converte os valores de String para Double e retorna a soma
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // Método utilitário que converte uma String para Double
    // Se for null, retorna 0.0 como valor padrão
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0d;

        // Substitui vírgulas por pontos para lidar com diferentes formatos de número (ex: brasileiro vs americano)
        String number = strNumber.replaceAll(",", ".");

        // Converte a String para Double
        return Double.parseDouble(number);
    }

    // Método utilitário que verifica se uma String representa um número válido
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;

        // Substitui vírgulas por pontos para normalizar o número
        String number = strNumber.replaceAll(",", ".");

        // Expressão regular para verificar se a String é um número (positivo, negativo, inteiro ou decimal)
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
