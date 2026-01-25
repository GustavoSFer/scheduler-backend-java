package br.com.fernandes.scheduler_backend_java.service;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.mapper.pessoaMapper.PessoaMappers;
import br.com.fernandes.scheduler_backend_java.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaEntity create(PessoaDTO pessoa) {
        PessoaEntity pessoaEntity = PessoaMappers.PessoaDtoToEntity(pessoa);

        return pessoaRepository.save(pessoaEntity);
    }
}
