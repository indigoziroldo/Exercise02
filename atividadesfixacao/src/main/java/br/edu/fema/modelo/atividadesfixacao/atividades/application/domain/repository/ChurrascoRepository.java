package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChurrascoRepository extends JpaRepository<ChurrascoEntity, Long> {

    List<ChurrascoEntity> findByDataInicioGreaterThanEqual(LocalDateTime dataBusca);

    List<ChurrascoEntity> findAllByDataInicioBetween (LocalDateTime dataBuscaInicio, LocalDateTime dataBuscaFim);
}
