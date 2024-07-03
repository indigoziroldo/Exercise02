package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class EnderecoForm {

    private String rua;

    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento; //  pode ser null
}
