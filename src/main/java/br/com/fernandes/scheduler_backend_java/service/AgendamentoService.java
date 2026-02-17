package br.com.fernandes.scheduler_backend_java.service;

import br.com.fernandes.scheduler_backend_java.dto.AgendamentoDTO;
import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.exception.agendamento.AgendamentoNotFoundException;
import br.com.fernandes.scheduler_backend_java.exception.agendamento.FilterNullException;
import br.com.fernandes.scheduler_backend_java.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PessoaService pessoaService;

    public AgendamentoEntity create(AgendamentoDTO agendamento) {
        LocalDateTime now = LocalDateTime.now();
        if (agendamento.dataAgendamento() == null || !agendamento.dataAgendamento().isAfter(now)) {
            throw new RuntimeException("A data do agendamento deve ser futura.");
        }

        PessoaEntity pessoa = pessoaService.findById(agendamento.pessoa());
        AgendamentoEntity agendamentoEntity = new AgendamentoEntity();
        agendamentoEntity.setDataAgendamento(agendamento.dataAgendamento());
        agendamentoEntity.setValor(agendamento.valor());
        agendamentoEntity.setPago(agendamento.pago());
        agendamentoEntity.setPessoa(pessoa);

        return agendamentoRepository.save(agendamentoEntity);

    }

    public AgendamentoEntity findById(Long id) {
        Optional<AgendamentoEntity> agendamento =  agendamentoRepository.findById(id);

        return agendamento.orElseThrow(() -> new AgendamentoNotFoundException("Agendamento com id " + id + " não encontrado."));
    }

    public List<AgendamentoEntity> findAll() {
        return agendamentoRepository.findAll();
    }

    public List<AgendamentoEntity> findAllToday() {
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime startOfNextDay = today.plusDays(1).atStartOfDay();

        return agendamentoRepository.findAllByDataAgendamentoBetweenDay(startOfDay, startOfNextDay);
    }

    public List<AgendamentoEntity> findAllFilter(LocalDateTime dataAgendamentoInicio, LocalDateTime dataAgendamentoFim) {
        if (dataAgendamentoInicio != null && dataAgendamentoFim == null) {
            throw new FilterNullException("O filtro de data de fim é obrigatório quando o filtro de data de início é fornecido.");
        }
        return agendamentoRepository.findAllByDataAgendamentoBetweenDay(dataAgendamentoInicio, dataAgendamentoFim);
    }
}
