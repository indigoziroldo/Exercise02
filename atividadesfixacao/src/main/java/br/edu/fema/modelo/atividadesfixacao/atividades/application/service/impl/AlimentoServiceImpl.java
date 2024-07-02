package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.AlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.TipoAlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlimentoServiceImpl implements AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final TipoAlimentoRepository tipoAlimentoRepository;


    // CREATE
    @Override
    @Transactional
    public void criarAlimento(AlimentoForm alimentoForm) {
        AlimentoEntity alimentoCriado = new AlimentoEntity();
        alimentoCriado.setDescricao(alimentoForm.getDescricao());
        alimentoCriado.setValor(alimentoForm.getValorAlimento());
        alimentoCriado.setQuantidade(alimentoForm.getQuantidade());
        alimentoCriado.setIdTipoAlimento(alimentoForm.getIdTipoAlimento());
        this.alimentoRepository.save(alimentoCriado);
    }

    // READ
    @Override
    public List<AlimentoDTO> buscarTodosOsAlimentos() {
        List<AlimentoEntity> listaDeAlimentos = this.alimentoRepository.findAll();
        if(listaDeAlimentos.isEmpty()) throw new RuntimeException("lista de alimentos está vazia");
        return AlimentoDTO.converter(listaDeAlimentos);
    }


    // UPDATE
    @Override
    public void atualizarAlimento(AlimentoForm alimentoForm, UUID id) {
        Optional<AlimentoEntity> alimentoEncontrado = alimentoRepository.findById(id);
        if(alimentoEncontrado.isEmpty()) throw new RuntimeException("esse Alimento não existe");

        alimentoRepository.save(converterFormParaEntity(alimentoForm, id));
    }
    public AlimentoEntity converterFormParaEntity(AlimentoForm formToEntity, UUID id){
        AlimentoEntity alimentoEntity = new AlimentoEntity();
        alimentoEntity.setId(id);
        alimentoEntity.setDescricao(formToEntity.getDescricao());
        alimentoEntity.setValor(formToEntity.getValorAlimento());
        alimentoEntity.setQuantidade(formToEntity.getQuantidade());
        alimentoEntity.setIdTipoAlimento(formToEntity.getIdTipoAlimento());
        alimentoEntity.setTipoAlimento(
                tipoAlimentoRepository
                        .findById(
                            formToEntity.getIdTipoAlimento())
                        .orElseThrow(
                                () -> new ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        "Tipo alimento não encontrado!")));
        return alimentoEntity;
    }

    // DELETE
    @Override
    public void deletarAlimentoPorId(UUID id) {
        alimentoRepository.deleteById(id);
    }

}
