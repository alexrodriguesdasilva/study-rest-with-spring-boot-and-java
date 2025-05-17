package study_rest_with_spring_boot_and_java.model;

// 'record' é um tipo especial no Java que representa uma classe imutável com campos simples.
// Aqui, Greeting tem dois campos: id (long) e content (String).
// Ele serve como um "modelo" para representar a resposta JSON da API.
public record Greeting(long id, String content) {}
