package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.apache.bcel.generic.RET;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
@Setter
@NoArgsConstructor
public class ChurrascoDTO {

    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private LugarDTO lugarDTO;
    private PessoaDTO anfitriao;

    public ChurrascoDTO (ChurrascoEntity churrascoEntity){
        this.id = churrascoEntity.getId();
        this.dataInicio = churrascoEntity.getDataInicio();
        this.dataFim = churrascoEntity.getDataFim();
        this.lugarDTO = new LugarDTO(churrascoEntity.getLugar());
        this.anfitriao = new PessoaDTO(churrascoEntity.getAnfitriao());

    }

    public static List<ChurrascoDTO> converter(List<ChurrascoEntity> listadeChurrascos) {
        return listadeChurrascos.stream().map(ChurrascoDTO::new).collect(Collectors.toList());
    }
}
