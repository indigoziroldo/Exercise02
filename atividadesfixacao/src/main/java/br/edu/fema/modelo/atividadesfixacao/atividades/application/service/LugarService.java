package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.LugarDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.LugarForm;

import java.util.List;
import java.util.UUID;

public interface LugarService {

    // CREATE
    void criarLugar(LugarForm lugarForm);

    // READ
    List<LugarDTO> buscarLugares();

    // UPDATE
    void atualizarLugar(LugarForm lugarForm, UUID id);

    // DELETE
    void deletarLugar(UUID id);


}
