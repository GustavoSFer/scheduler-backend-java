package br.com.fernandes.scheduler_backend_java.controller;

import br.com.fernandes.scheduler_backend_java.dto.AgendamentoDTO;
import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;
import br.com.fernandes.scheduler_backend_java.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
