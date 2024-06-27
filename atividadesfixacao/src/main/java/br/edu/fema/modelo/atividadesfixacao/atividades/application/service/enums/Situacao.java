package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums;

import br.edu.fema.modelo.atividadesfixacao.utils.conversao.enums.interfaces.ValorEnum;
import br.edu.fema.modelo.atividadesfixacao.utils.conversao.enums.service.DesserializadorEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonDeserialize(using = DesserializadorEnum.class)
public enum Situacao implements ValorEnum<String> {

    CONFIRMADO("C", "Confirmado"),
    AGUARDANDO("A", "Aguardando"),
    RECUSADO("R", "Recusado");

    private String valor;
    private String descricao;
}
