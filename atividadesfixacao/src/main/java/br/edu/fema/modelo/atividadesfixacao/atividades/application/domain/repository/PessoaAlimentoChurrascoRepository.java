package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaAlimentoChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable.PessoaAlimentoChurrascoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaAlimentoChurrascoRepository extends JpaRepository<PessoaAlimentoChurrascoEntity, PessoaAlimentoChurrascoId> {



}
