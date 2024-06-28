package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.TipoAlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.TipoAlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.TipoAlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.TipoAlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoAlimentoServiceImpl implements TipoAlimentoService{

    private final TipoAlimentoRepository tipoAlimentoRepository;

    // CREATE
    @Override
    public void criarTipoAlimento(TipoAlimentoForm tipoAlimentoForm) {
        TipoAlimentoEntity tipoAlimentoCriado = new TipoAlimentoEntity();
        tipoAlimentoCriado.setDescricao(tipoAlimentoForm.getDescricao());
        this.tipoAlimentoRepository.save(tipoAlimentoCriado);
    }

    // READ
    @Override
    public List<TipoAlimentoDTO> buscarTiposAlimentos() {
        List<TipoAlimentoEntity> listaTipoAlimentos = this.tipoAlimentoRepository.findAll();
        if(listaTipoAlimentos.isEmpty()) throw new RuntimeException("lista de tipos de alimentos está vazia");
        return TipoAlimentoDTO.converter(listaTipoAlimentos);
    }

    // UPDATE
    @Override
    public void atualizarTipoAlimento(TipoAlimentoForm tipoAlimentoForm, Long id) {
        Optional<TipoAlimentoEntity> tipoAlimentoEncontrado = tipoAlimentoRepository.findById(id);
        if(tipoAlimentoEncontrado.isEmpty()) throw new RuntimeException("esse tipo alimento não existe");
        tipoAlimentoRepository.save(converterFormParaEntity(tipoAlimentoForm, id));

    }

    private TipoAlimentoEntity converterFormParaEntity(TipoAlimentoForm formToEntity, Long id) {
        TipoAlimentoEntity tipoAlimentoEntity = new TipoAlimentoEntity();
        tipoAlimentoEntity.setId(id);
        tipoAlimentoEntity.setDescricao(formToEntity.getDescricao());
        return tipoAlimentoEntity;
    }

    // DELETE
    @Override
    public void deletarTipoAlimento(Long id) {
        tipoAlimentoRepository.deleteById(id);
    }
}
