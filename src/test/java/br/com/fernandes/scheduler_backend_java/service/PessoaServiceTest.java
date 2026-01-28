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

import java.util.List;

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

    @Test
    @Description("Buscando a lista de pessoas com sucesso")
    void listarPessoaComSucesso() {
        //Given
        List<PessoaEntity> pessoasMock = List.of(PessoasEntityMock.pessoaEntityCriada());

        //When
        when(pessoaRepository.findAll()).thenReturn(pessoasMock);

        List<PessoaEntity> pessoas = pessoaService.findAll();

        //Then
        assertAll(
                () -> assertEquals(pessoasMock.get(0).getNome(), pessoas.get(0).getNome()),
                () -> assertEquals(pessoasMock.get(0).getEmail(), pessoas.get(0).getEmail()),
                () -> assertEquals(pessoasMock.get(0).getTelefone(), pessoas.get(0).getTelefone()),
                () -> assertEquals(pessoasMock.get(0).getId(), 1L)
        );
    }

}