package br.com.fernandes.scheduler_backend_java.controller;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PessoaEntity>> findAll() {
        List<PessoaEntity> pessoas = pessoaService.findAll();

        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEntity> findById(@PathVariable Long id) {
        PessoaEntity pessoa = pessoaService.findById(id);

        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaEntity> update(@RequestParam Long id, @Valid @RequestBody PessoaDTO pessoa) {
        PessoaEntity pessoaAtualizada = pessoaService.update(id, pessoa);

        return ResponseEntity.ok().body(pessoaAtualizada);
    }
}
