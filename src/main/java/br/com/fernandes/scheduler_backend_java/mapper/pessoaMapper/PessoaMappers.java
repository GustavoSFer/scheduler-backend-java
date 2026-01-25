package br.com.fernandes.scheduler_backend_java.mapper.pessoaMapper;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;

public class PessoaMappers {

    public static PessoaEntity PessoaDtoToEntity(PessoaDTO pessoaDTO) {
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setEmail(pessoaDTO.email());
        pessoa.setTelefone(pessoaDTO.telefone());

        return pessoa;
    }
}
