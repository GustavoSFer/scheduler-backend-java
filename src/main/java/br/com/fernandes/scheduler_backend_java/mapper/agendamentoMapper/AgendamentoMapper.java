package br.com.fernandes.scheduler_backend_java.mapper.agendamentoMapper;

import br.com.fernandes.scheduler_backend_java.dto.AgendamentoDTO;
import br.com.fernandes.scheduler_backend_java.dto.AgendamentoResponseDTO;
import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;

public class AgendamentoMapper {

    public static AgendamentoResponseDTO AgendamentoEntityToAgendamentoResponseDTO(AgendamentoEntity agendamento) {
        AgendamentoResponseDTO agendamentoResponseDTO = new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDataAgendamento(),
                agendamento.getValor(),
                agendamento.getPessoa().getId(),
                agendamento.getPago()
        );

        return agendamentoResponseDTO;
    }
}
