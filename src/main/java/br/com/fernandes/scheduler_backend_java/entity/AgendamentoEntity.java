package br.com.fernandes.scheduler_backend_java.entity;

import br.com.fernandes.scheduler_backend_java.entity.Enum.StatusPagamento;
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
@Table(name = "Agenda")
public class AgendamentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime dataAgendamento;
    BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)  //Evita trazer a pessoa sem necessidade (boa prática)
    @JoinColumn(name = "pessoa_id", nullable = false)
    PessoaEntity pessoa;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento")
    StatusPagamento pago;

}
