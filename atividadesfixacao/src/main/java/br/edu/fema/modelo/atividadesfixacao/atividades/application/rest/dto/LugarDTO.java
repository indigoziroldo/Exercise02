package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.LugarEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable.Endereco;
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
public class LugarDTO {

    private UUID idLugar;
    private Integer vagaEstacionamento;
    private Integer limiteDePessoas;
    private BigDecimal valor;
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;



    public LugarDTO(LugarEntity lugarEntity){
        this.idLugar = lugarEntity.getId();
        this.vagaEstacionamento = lugarEntity.getVagasEstacionamento();
        this.limiteDePessoas = lugarEntity.getLimiteDePessoas();
        this.valor = lugarEntity.getValor();
        this.rua = lugarEntity.getEndereco().getRua();
        this.numero = lugarEntity.getEndereco().getNumero();
        this.cep = lugarEntity.getEndereco().getCep();
        this.cidade = lugarEntity.getEndereco().getCidade();
        this.estado = lugarEntity.getEndereco().getEstado();
        this.complemento = lugarEntity.getEndereco().getComplemento();
    }

    public static List<LugarDTO> converter(List<LugarEntity> listaLugares) {
        return listaLugares.stream().map(LugarDTO::new).collect(Collectors.toList());
    }
}
