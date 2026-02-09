package br.com.fernandes.scheduler_backend_java.repository;

import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

    @Query("SELECT a FROM AgendamentoEntity a WHERE a.dataAgendamento >= :start AND a.dataAgendamento < :end")
    List<AgendamentoEntity> findAllByDataAgendamentoBetweenDay(LocalDateTime start, LocalDateTime end);

}
