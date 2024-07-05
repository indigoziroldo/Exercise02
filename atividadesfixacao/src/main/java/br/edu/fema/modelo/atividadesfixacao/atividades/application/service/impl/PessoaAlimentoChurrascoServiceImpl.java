package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaAlimentoChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.PessoaAlimentoChurrascoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.PessoaAlimentoChurrascoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaAlimentoChurrascoServiceImpl{

    private final PessoaAlimentoChurrascoRepository pessoaAlimentoChurrascoRepository;

    public PessoaAlimentoChurrascoServiceImpl(PessoaAlimentoChurrascoRepository pessoaAlimentoChurrascoRepository) {
        this.pessoaAlimentoChurrascoRepository = pessoaAlimentoChurrascoRepository;
    }

    public List <PessoaAlimentoChurrascoEntity> busca (){
        List<PessoaAlimentoChurrascoEntity> teste = this.pessoaAlimentoChurrascoRepository.findAll();
        return teste;

    }
}
