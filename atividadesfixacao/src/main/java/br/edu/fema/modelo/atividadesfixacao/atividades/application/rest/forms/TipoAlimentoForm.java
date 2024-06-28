package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TipoAlimentoForm {

    @NotNull(message = "Não pode ser nulo")
    private String descricao;

}
