package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TipoAlimentoDTO {

    private String descricao;

    public TipoAlimentoDTO(TipoAlimentoEntity tipoAlimentoEntity){
        this.descricao = tipoAlimentoEntity.getDescricao();
    }

    public static List<TipoAlimentoDTO> converter(List<TipoAlimentoEntity> listaDeTipoAlimento){
        return listaDeTipoAlimento.stream().map(TipoAlimentoDTO::new).collect(Collectors.toList());
    }
}
