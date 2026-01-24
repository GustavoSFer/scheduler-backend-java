package br.com.fernandes.scheduler_backend_java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime dataAgendamento;
    BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)  //Evita trazer a pessoa sem necessidade (boa prática)
    @JoinColumn(name = "pessoa_id", nullable = false)
    PessoaEntity pessoa;

}
