package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums.Locomocao;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.enums.Situacao;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pessoa", schema = "atividade_fixacao")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome VARCHAR(50),
    @Column
    private String nome;

    // situacao VARCHAR(20),
    @Column
    private Situacao situacao; // fazer referencia ao enum

    // telefone VARCHAR(15),
    @Column
    private String telefone;

    // locomocao VARCHAR(20),
    @Column
    private Locomocao locomocao; // fazer referencia ao enum

    // data_confirmacao VARCHAR(11),
    @Column(name = "data_confirmacao")
    private String dataConfirmacao;

}
