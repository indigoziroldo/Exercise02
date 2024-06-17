package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;


import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;

import java.util.List;

public interface ChurrascoService {
    List<ChurrascoEntity> buscarTodosChurrascos();

    List<ChurrascoEntity> buscarTodosChurrascosPorData(String dataBusca);

    List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(String dataBuscaInicio, String dataBuscaFim);
}
