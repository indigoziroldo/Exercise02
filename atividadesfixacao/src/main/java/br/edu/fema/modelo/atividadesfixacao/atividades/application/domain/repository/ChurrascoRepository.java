package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ChurrascoRepository extends JpaRepository<ChurrascoEntity, Long> {

    List<ChurrascoEntity> findByDataInicioGreaterThanEqual(LocalDateTime dataBusca);
}
