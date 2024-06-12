package br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    //    rua VARCHAR(40),
    @Column
    private String rua;

    //    numero VARCHAR(10),
    @Column
    private String numero;

    //    cep VARCHAR(9),
    @Column
    private String cep;

    //    cidade VARCHAR(30),
    @Column
    private String cidade;

    //    estado VARCHAR(30),
    @Column
    private String estado;

    //    complemento VARCHAR(30),
    @Column
    private String complemento; //  pode ser null


}