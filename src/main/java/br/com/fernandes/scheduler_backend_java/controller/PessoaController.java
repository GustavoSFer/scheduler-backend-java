package br.com.fernandes.scheduler_backend_java.controller;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaEntity> create(@Valid @RequestBody PessoaDTO pessoa) {
        PessoaEntity pessoaCriada = pessoaService.create(pessoa);

        return ResponseEntity.ok().body(pessoaCriada);
    }
}
