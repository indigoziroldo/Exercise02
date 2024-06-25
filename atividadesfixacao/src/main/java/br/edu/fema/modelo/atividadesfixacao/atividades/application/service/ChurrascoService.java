package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;


import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ChurrascoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ValorPessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.ChurrascoForm;

import java.util.List;

public interface ChurrascoService {
    List<ChurrascoEntity> buscarTodosChurrascos();

    List<ChurrascoEntity> buscarTodosChurrascosPorData(String dataBusca);

    List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(String dataBuscaInicio, String dataBuscaFim);

    List<ValorPessoaDTO> buscarAlimentosPorValor();

    // CREATE
    void criarChurrasco(ChurrascoForm churrascoForm);

    // READ
    List<ChurrascoDTO> buscarTodosOsChurrascos();

    // UPDATE
    void atualizarChurrasco(ChurrascoForm churrascoForm, long id);

    // DELETE
    void deletarChurrascoPorId(long id);
}
