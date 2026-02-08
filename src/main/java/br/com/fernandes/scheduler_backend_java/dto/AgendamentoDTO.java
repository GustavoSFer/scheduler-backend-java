package br.com.fernandes.scheduler_backend_java.dto;

import br.com.fernandes.scheduler_backend_java.entity.Enum.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoDTO(
        @JsonProperty("dataAgendamento")
        @NotNull(message = "A data do agendamento é obrigatória")
        @FutureOrPresent(message = "A data não pode ser no passado")
        LocalDateTime dataAgendamento,

        @JsonProperty("valor")
        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser maior que zero")
        BigDecimal valor,

        @JsonProperty("pessoa")
        @NotNull(message = "O ID da pessoa é obrigatório")
        Long pessoa,

        @JsonProperty("pago")
        @NotNull(message = "O status de pagamento é obrigatório")
        StatusPagamento pago
) {
}
