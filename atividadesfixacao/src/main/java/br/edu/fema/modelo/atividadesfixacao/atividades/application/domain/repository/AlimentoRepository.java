package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlimentoRepository extends JpaRepository<AlimentoEntity, UUID> {
}
