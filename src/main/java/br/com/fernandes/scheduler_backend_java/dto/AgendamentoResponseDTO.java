package br.com.fernandes.scheduler_backend_java.dto;

import br.com.fernandes.scheduler_backend_java.entity.Enum.StatusPagamento;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponseDTO {
        @JsonProperty("id")
        Long id;

        @JsonProperty("dataAgendamento")
        LocalDateTime dataAgendamento;

        @JsonProperty("valor")
        BigDecimal valor;

        @JsonProperty("pessoa")
        Long pessoa;

        @JsonProperty("pago")
        StatusPagamento pago;
}

