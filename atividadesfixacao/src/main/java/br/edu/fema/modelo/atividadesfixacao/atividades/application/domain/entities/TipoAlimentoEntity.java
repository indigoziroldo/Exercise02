package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tipo_comes_e_bebes")
public class TipoAlimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id; // ta long no Repository

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_alimento")
    private AlimentoEntity alimento;
}