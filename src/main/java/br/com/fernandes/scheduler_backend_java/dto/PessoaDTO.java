package br.com.fernandes.scheduler_backend_java.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record PessoaDTO (
        @JsonProperty("nome")
        @NotBlank(message = "O atributo nome não pode ser nulo nem vazio.")
        String nome,
        @JsonProperty("email")
        @NotBlank(message = "O atributo email não pode ser nulo nem vazio.")
        String email,
        @JsonProperty("telefone")
        @NotBlank(message = "O atributo telefone não pode ser nulo nem vazio.")
        String telefone
){

}
