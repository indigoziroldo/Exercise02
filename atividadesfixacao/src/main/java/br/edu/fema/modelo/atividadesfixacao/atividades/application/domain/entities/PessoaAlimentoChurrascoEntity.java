package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities;


import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable.PessoaAlimentoChurrascoId;
import jakarta.persistence.*;

@jakarta.persistence.Entity
@Table(name = "pessoa_alimento_xhurrasco", schema = "public")
public class PessoaAlimentoChurrascoEntity {

    @EmbeddedId
    private PessoaAlimentoChurrascoId id;

    //    quantidade INTEGER,
    @Column
    private Integer quantidade;

    @ManyToOne
    @MapsId("idPessoa")
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

    @ManyToOne
    @MapsId("idAlimento")
    @JoinColumn(name = "id_alimento")
    private AlimentoEntity alimento;

    @ManyToOne
    @MapsId("idChurrasco")
    @JoinColumn(name = "id_xhurrasco")
    private ChurrascoEntity churrasco;
}
