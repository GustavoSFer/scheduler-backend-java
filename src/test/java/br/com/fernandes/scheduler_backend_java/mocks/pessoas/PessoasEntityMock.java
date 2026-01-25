package br.com.fernandes.scheduler_backend_java.mocks.pessoas;

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
}
