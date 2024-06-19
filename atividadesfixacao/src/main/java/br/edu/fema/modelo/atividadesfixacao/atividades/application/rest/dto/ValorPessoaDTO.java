package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValorPessoaDTO {

    private String nomePessoa;

    private BigDecimal valorTotal;

    private List<AlimentoDTO> alimento;
}
