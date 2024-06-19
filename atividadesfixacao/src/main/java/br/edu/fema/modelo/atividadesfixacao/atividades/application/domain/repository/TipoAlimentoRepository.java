package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAlimentoRepository extends JpaRepository<TipoAlimentoEntity, Long> {
}
