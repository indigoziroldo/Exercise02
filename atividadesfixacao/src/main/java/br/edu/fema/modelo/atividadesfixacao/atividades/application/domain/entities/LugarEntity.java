package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor


@jakarta.persistence.Entity
@Table(name = "lugar", schema = "atividade_fixacao")
public class LugarEntity {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //    vagas_estacionamento INTEGER,
    @Column(name = "vagas_estacionamento")
    private Integer vagasEstacionamento;

    //    limite_de_pessoas INTEGER,
    @Column(name = "limite_de_pessoas")
    private Integer limiteDePessoas;

    //    valor DECIMAL(5,2),
    @Column
    private BigDecimal valor; // pode ser null

    @Embedded
    private Endereco endereco;

}