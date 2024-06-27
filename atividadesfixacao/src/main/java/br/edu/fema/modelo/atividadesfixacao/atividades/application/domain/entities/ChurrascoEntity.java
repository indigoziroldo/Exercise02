package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "xhurrasco", schema = "atividade_fixacao")
public class ChurrascoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;


    @Column(name = "id_lugar")
    private UUID idLugar;

    @ManyToOne
    @JoinColumn(name = "id_lugar", updatable = false, insertable = false)
    private LugarEntity lugar;


    @Column(name = "anfitriao")
    private Long idAnfitriao;

    @OneToOne
    @JoinColumn(name = "anfitriao", updatable = false, insertable = false)
    private PessoaEntity anfitriao;

}