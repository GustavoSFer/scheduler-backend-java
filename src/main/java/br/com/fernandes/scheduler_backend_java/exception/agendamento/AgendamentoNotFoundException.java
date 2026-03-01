package br.com.fernandes.scheduler_backend_java.exception.agendamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoNotFoundException extends RuntimeException {
    private String msg;
}
