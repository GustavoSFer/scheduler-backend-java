package br.com.fernandes.scheduler_backend_java.controller;

import br.com.fernandes.scheduler_backend_java.dto.PessoaDTO;
import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import br.com.fernandes.scheduler_backend_java.mocks.pessoas.PessoasEntityMock;
import br.com.fernandes.scheduler_backend_java.service.PessoaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {

    @MockBean
    private PessoaService pessoaService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private final String PATH = "/pessoas";

    @Test
    @DisplayName("Deve criar uma pessoa com sucesso")
    void create() throws Exception {
        PessoaDTO pessoaDTO = PessoasEntityMock.PessoaEntityDTO();

        when(pessoaService.create(pessoaDTO)).thenReturn(PessoasEntityMock.pessoaEntityCriada());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoaDTO)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(1L))
                    .andExpect(jsonPath("$.nome").value("Gustavo Fernandes"))
                    .andExpect(jsonPath("$.email").value("Gustavofernandes@gmail.com"))
                    .andExpect(jsonPath("$.telefone").value("11969581233"));

    }

    @Test
    @DisplayName("Deve informar error ao criar pessoa com dados inválidos")
    void createPessoaInvalido() throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO("", "emailinvalido", "123");

        when(pessoaService.create(pessoaDTO)).thenReturn(PessoasEntityMock.pessoaEntityCriada());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoaDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve listar todas as pessoas com sucesso")
    void findAll() throws Exception {
        List<PessoaEntity> pessoasMock = List.of(PessoasEntityMock.pessoaEntityCriada());

        when(pessoaService.findAll()).thenReturn(pessoasMock);

        mockMvc.perform(get(PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nome").value("Gustavo Fernandes"))
                .andExpect(jsonPath("$[0].email").value("Gustavofernandes@gmail.com"))
                .andExpect(jsonPath("$.[0].telefone").value("11969581233"));
    }
}