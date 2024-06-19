package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor @ToString

@Entity
@Table(name = "tipo_comes_e_bebes")
public class TipoAlimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id; // ta long no Repository

    @Column
    private String descricao;
}