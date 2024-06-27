package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.LugarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LugarRepository extends JpaRepository<LugarEntity, UUID> {

}
