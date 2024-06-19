package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlimentoService {

    List<AlimentoDTO> buscarTodosOsAlimentos();

    void criarAlimento(AlimentoForm alimentoForm);
}
