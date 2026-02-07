package br.com.fernandes.scheduler_backend_java.exception.pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaNotFoundException extends RuntimeException{
    private String mensagem;
}
