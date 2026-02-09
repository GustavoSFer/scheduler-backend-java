package br.com.fernandes.scheduler_backend_java.controller;

import br.com.fernandes.scheduler_backend_java.dto.AgendamentoDTO;
import br.com.fernandes.scheduler_backend_java.dto.AgendamentoResponseDTO;
import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;
import br.com.fernandes.scheduler_backend_java.mapper.agendamentoMapper.AgendamentoMapper;
import br.com.fernandes.scheduler_backend_java.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoEntity> create(@Valid @RequestBody AgendamentoDTO agendamentoDTO) {
        AgendamentoEntity agendamentoCriado = agendamentoService.create(agendamentoDTO);

        return ResponseEntity.ok().body(agendamentoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> fundById(@PathVariable Long id) {
        AgendamentoEntity agendamento = agendamentoService.findById(id);

        AgendamentoResponseDTO agendamentoResponseDTO = AgendamentoMapper.AgendamentoEntityToAgendamentoResponseDTO(agendamento);

        return ResponseEntity.ok().body(agendamentoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> findAll() {
        List<AgendamentoEntity> agendamentos = agendamentoService.findAll();

        List<AgendamentoResponseDTO> agendamentoResponseDTO = agendamentos.stream()
                .map(AgendamentoMapper::AgendamentoEntityToAgendamentoResponseDTO)
                .collect(toList());

        return ResponseEntity.ok().body(agendamentoResponseDTO);
    }

}

