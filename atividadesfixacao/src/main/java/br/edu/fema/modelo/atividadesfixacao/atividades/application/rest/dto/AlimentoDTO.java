package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.AlimentoService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AlimentoDTO {

    private UUID id;

    private String descricao;

    private BigDecimal valor;

    private TipoAlimentoDTO tipoAlimentoDTO;

    public AlimentoDTO(AlimentoEntity alimentoEntity){
        this.id = alimentoEntity.getId();
        this.descricao = alimentoEntity.getDescricao();
        this.valor = alimentoEntity.getValor();
        this.tipoAlimentoDTO = new TipoAlimentoDTO(alimentoEntity.getTipoAlimento());
    }

    public static List<AlimentoDTO> converter(List<AlimentoEntity> listaDeAlimento){
        return listaDeAlimento.stream().map(AlimentoDTO::new).collect(Collectors.toList());
    }

}
