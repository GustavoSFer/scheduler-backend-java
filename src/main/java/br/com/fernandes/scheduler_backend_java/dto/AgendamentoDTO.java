package br.com.fernandes.scheduler_backend_java.dto;

import br.com.fernandes.scheduler_backend_java.entity.Enum.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoDTO(
        LocalDateTime dataAgendamento,
        BigDecimal valor,
        Long pessoa,
        StatusPagamento pago
) {
}
