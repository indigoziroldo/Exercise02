package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ChurrascoForm {

    @NotNull(message = "Campo não pode ser nulo")
    private String dataInicio;
    private String dataFim;
    private UUID idLocal;
    private long idAnfitriao;
}
