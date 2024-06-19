package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AlimentoForm {

    @NotNull(message = "Campo descricao não pode ser nulo")
    private String descricao;
    private BigDecimal valorAlimento;
    private Long idTipoAlimento;
}
