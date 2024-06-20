package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.AlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;

import java.util.List;
import java.util.UUID;

public interface AlimentoService {


    // CREATE
    void criarAlimento(AlimentoForm alimentoForm);

    //READ
    List<AlimentoDTO> buscarTodosOsAlimentos();

    //UPDATE
    void atualizarAlimento(AlimentoForm alimentoForm, UUID id);

    // DELETE
    void deletarAlimentoPorId(UUID id);

}
