package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class LugarForm {

    @NotNull(message = "Não pode ser nulo")
    private String rua;
    private String cep;
    private String cidade;
    private String numero;
    private String estado;
    private String complemento;
    private Integer vagasEstacionamento;
    private Integer limiteDePessoas;
    private BigDecimal valor;

}
