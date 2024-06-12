package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "comes_e_bebes")
public class AlimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    //    descricao VARCHAR(50),
    @Column
    private String descricao;

    //    valor DECIMAL(7,2),
    @Column
    private BigDecimal valor;

    @OneToMany(mappedBy = "alimento")
    private List<TipoAlimentoEntity> tipoAlimento;

}
