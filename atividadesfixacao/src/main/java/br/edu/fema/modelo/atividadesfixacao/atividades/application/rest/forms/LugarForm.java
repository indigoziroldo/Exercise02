package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class LugarForm {


    private Integer vagasEstacionamento;
    private Integer limiteDePessoas;
    private BigDecimal valor;

    private EnderecoForm enderecoForm;

}
