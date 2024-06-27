package br.edu.fema.modelo.atividadesfixacao.atividades.application.service;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.PessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.PessoaForm;

import java.util.List;

public interface PessoaService {

    // CREATE
    void criarPessoa(PessoaForm pessoaForm);

    // READ
    List<PessoaDTO> buscarPessoas();

    // UPDATE
    void atualizarPessoa(PessoaForm pessoaForm, Long id);

    // DELETE
    void deletarPessoa(Long id);
}
