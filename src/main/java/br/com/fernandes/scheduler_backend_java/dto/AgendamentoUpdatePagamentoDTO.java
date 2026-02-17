package br.com.fernandes.scheduler_backend_java.dto;

import br.com.fernandes.scheduler_backend_java.entity.Enum.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record AgendamentoUpdatePagamentoDTO(
        @JsonProperty("pago")
        @NotNull(message = "O status de pagamento é obrigatório")
        StatusPagamento pago
) {
}
