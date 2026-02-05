package br.com.fernandes.scheduler_backend_java.service;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.exception.pessoa.PessoaNotFoundException;
import br.com.fernandes.scheduler_backend_java.mapper.pessoaMapper.PessoaMappers;
import br.com.fernandes.scheduler_backend_java.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaEntity create(PessoaDTO pessoa) {
        PessoaEntity pessoaEntity = PessoaMappers.PessoaDtoToEntity(pessoa);

        return pessoaRepository.save(pessoaEntity);
    }

    public List<PessoaEntity> findAll() {
        return pessoaRepository.findAll();
    }

    public PessoaEntity findById(Long id) {
        Optional<PessoaEntity> pessoa =  pessoaRepository.findById(id);

        return pessoa.orElseThrow(() -> new PessoaNotFoundException("Pessoa com id " + id + " não encontrada."));
    }

    public PessoaEntity update(Long id, PessoaDTO pessoa) {
        PessoaEntity pessoaExistente = pessoaRepository.findById(id).orElse(null);
        if (pessoaExistente != null) {
            PessoaMappers.updatePessoaEntityFromDto(pessoa, pessoaExistente);
            return pessoaRepository.save(pessoaExistente);
        }
        return null;
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
