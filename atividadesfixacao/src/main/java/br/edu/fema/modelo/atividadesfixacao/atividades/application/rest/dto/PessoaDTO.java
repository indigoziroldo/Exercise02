package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;


import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums.Locomocao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String locomocao;
    private String situacao;
    private String dataConfirmacao;


    public PessoaDTO(PessoaEntity anfitriao) {
        this.id = anfitriao.getId();
        this.nome = anfitriao.getNome();
        this.telefone = anfitriao.getTelefone();
        this.locomocao = anfitriao.getLocomocao().getDescricao();
        this.situacao = anfitriao.getSituacao().getDescricao();
        this.dataConfirmacao = anfitriao.getDataConfirmacao();
    }

    public static List<PessoaDTO> converter(List<PessoaEntity> listaPessoas) {
        return listaPessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }
}
