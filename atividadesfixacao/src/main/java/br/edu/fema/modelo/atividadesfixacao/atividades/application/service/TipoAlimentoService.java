package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.TipoAlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.TipoAlimentoForm;

import java.util.List;

public interface TipoAlimentoService {

    // CREATE
    void criarTipoAlimento(TipoAlimentoForm tipoAlimentoForm);

    //READ
    List<TipoAlimentoDTO> buscarTiposAlimentos();

    //UPDATE
    void atualizarTipoAlimento(TipoAlimentoForm tipoAlimentoForm, Long id);

    // DELETE
    void deletarTipoAlimento(Long id);
}
