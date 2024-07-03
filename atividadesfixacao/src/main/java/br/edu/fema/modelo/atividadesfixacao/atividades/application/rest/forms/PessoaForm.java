package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums.Locomocao;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums.Situacao;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PessoaForm {

    @NotNull(message = "Campo não pode ser null")

    private Long id;
    private String nome;
    private Situacao situacao;
    private String telefone;
    private Locomocao locomocao;
    private String dataConfirmacao;
}
