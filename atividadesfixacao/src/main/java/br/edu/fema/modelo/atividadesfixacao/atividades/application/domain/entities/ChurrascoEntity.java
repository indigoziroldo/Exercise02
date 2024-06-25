package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "xhurrasco", schema = "public")
public class ChurrascoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;


    @Column(name = "id_local")
    private UUID idLocal;

    @ManyToOne
    @JoinColumn(name = "id_local", updatable = false, insertable = false)
    private LocalEntity local;


    @Column(name = "id_anfitriao")
    private Long idAnfitriao;

    @OneToOne
    @JoinColumn(name = "id_anfitriao", updatable = false, insertable = false)
    private PessoaEntity anfitriao;

}