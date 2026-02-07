package br.com.fernandes.scheduler_backend_java.repository;

import br.com.fernandes.scheduler_backend_java.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
