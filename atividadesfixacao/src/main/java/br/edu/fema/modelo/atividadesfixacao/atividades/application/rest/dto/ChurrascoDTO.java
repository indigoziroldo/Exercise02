package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import org.aspectj.apache.bcel.generic.RET;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ChurrascoDTO {

    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private UUID idLocal;
    private Long idAnfitriao;

    public static List<ChurrascoDTO> converter(List<ChurrascoEntity> listadeChurrascos) {
        return listadeChurrascos.stream().map(ChurrascoDTO::new).collect(Collectors.toList());
    }
}
