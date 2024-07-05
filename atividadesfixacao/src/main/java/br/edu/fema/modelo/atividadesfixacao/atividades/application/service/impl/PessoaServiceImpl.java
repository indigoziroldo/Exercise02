package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.PessoaRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.PessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.PessoaForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {




    private final PessoaRepository pessoaRepository;
   // public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

    @Override
    @Transactional
    public void criarPessoa(PessoaForm pessoaForm) {
        PessoaEntity pessoaCriada = new PessoaEntity();
        pessoaCriada.setNome(pessoaForm.getNome());
        pessoaCriada.setSituacao(pessoaForm.getSituacao());
        pessoaCriada.setTelefone(pessoaForm.getTelefone());
        pessoaCriada.setLocomocao(pessoaForm.getLocomocao());
        pessoaCriada.setDataConfirmacao(pessoaForm.getDataConfirmacao());
        this.pessoaRepository.save(pessoaCriada);
    }

    @Override
    public List<PessoaDTO> buscarPessoas() {
        List<PessoaEntity> listaPessoas = this.pessoaRepository.findAll();
        if(listaPessoas.isEmpty()) throw new RuntimeException("Lista de pessoas está vazia");
        return PessoaDTO.converter(listaPessoas);
    }

    @Override
    public void atualizarPessoa(PessoaForm pessoaForm, Long id) {
        Optional<PessoaEntity> pessoaEncontrada = pessoaRepository.findById(id);
        if(pessoaEncontrada.isEmpty()) throw new RuntimeException("Essa pessoa não existe");
        pessoaRepository.save(converterFormParaEntity(pessoaForm, id));

    }

    private PessoaEntity converterFormParaEntity(PessoaForm pessoaFormToEntity, Long id) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setId(id);
        pessoaEntity.setNome(pessoaFormToEntity.getNome());
        pessoaEntity.setSituacao(pessoaFormToEntity.getSituacao());
        pessoaEntity.setTelefone(pessoaFormToEntity.getTelefone());
        pessoaEntity.setLocomocao(pessoaFormToEntity.getLocomocao());
        pessoaEntity.setDataConfirmacao(pessoaFormToEntity.getDataConfirmacao());
        return pessoaEntity;
    }

    @Override
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
