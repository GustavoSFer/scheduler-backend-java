package br.com.fernandes.scheduler_backend_java.repository;

import br.com.fernandes.scheduler_backend_java.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
}
