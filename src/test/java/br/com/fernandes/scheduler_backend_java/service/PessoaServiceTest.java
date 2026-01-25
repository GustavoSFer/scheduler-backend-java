package br.com.fernandes.scheduler_backend_java.service;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.mocks.pessoas.PessoasEntityMock;
import br.com.fernandes.scheduler_backend_java.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    @Description("Criando uma pessoa com sucesso")
    void criandoPessoaComSucesso() {
        //Given
        PessoaEntity  pessoaMocado = PessoasEntityMock.pessoaEntityCriada();
        PessoaDTO pessoaDTO = new PessoaDTO("Gustavo Fernandes", "Gustavofernandes@gmail.com", "11969581233");

        //When
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaMocado);

        PessoaEntity pessoa = pessoaService.create(pessoaDTO);

        //Then
        assertAll(
                () -> assertEquals(pessoaMocado.getNome(), pessoa.getNome()),
                () -> assertEquals(pessoaMocado.getEmail(), pessoa.getEmail()),
                () -> assertEquals(pessoaMocado.getTelefone(), pessoa.getTelefone()),
                () -> assertEquals(pessoaMocado.getId(), 1L)
        );
    }

}