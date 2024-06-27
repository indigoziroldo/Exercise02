package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.LugarEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class LugarDTO {

    private UUID idLugar;
    private Integer vagaEstacionamento;
    private Integer limiteDePessoas;
    private BigDecimal valor;

    public LugarDTO(LugarEntity lugarEntity){
        this.idLugar = lugarEntity.getId();
        this.vagaEstacionamento = lugarEntity.getVagasEstacionamento();
        this.limiteDePessoas = lugarEntity.getLimiteDePessoas();
        this.valor = lugarEntity.getValor();

    }
}
