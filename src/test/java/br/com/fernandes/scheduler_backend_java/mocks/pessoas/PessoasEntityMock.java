package br.com.fernandes.scheduler_backend_java.mocks.pessoas;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;

public class PessoasEntityMock {


    public static PessoaEntity pessoaEntityCriada() {
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setId(1L);
        pessoa.setNome("Gustavo Fernandes");
        pessoa.setTelefone("11969581233");
        pessoa.setEmail("Gustavofernandes@gmail.com");

        return pessoa;
    }

    public static PessoaDTO PessoaEntityDTO() {
        return new PessoaDTO(
                "Fernando Silva",
                "fernandinhoSilva@gmail.com",
                "11987654321"
        );
    }
}
