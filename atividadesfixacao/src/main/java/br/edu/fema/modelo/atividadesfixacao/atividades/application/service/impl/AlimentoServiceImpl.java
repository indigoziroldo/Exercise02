package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.TipoAlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.AlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.TipoAlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller.TipoAlimentoController;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlimentoServiceImpl implements AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final TipoAlimentoRepository tipoAlimentoRepository;

    @Override
    public List<AlimentoDTO> buscarTodosOsAlimentos() {
        List<AlimentoEntity> listaDeAlimentos = this.alimentoRepository.findAll();
        if(listaDeAlimentos.isEmpty()) throw new RuntimeException("lista de alimentos está vazia");
        return AlimentoDTO.converter(listaDeAlimentos);
    }

    @Override
    @Transactional
    public void criarAlimento(AlimentoForm alimentoForm) {
        AlimentoEntity alimentoCriado = new AlimentoEntity();

        TipoAlimentoEntity tipoAlimentoEntity = this.tipoAlimentoRepository.findById(alimentoForm.getIdTipoAlimento()).get();

        alimentoCriado.setDescricao(alimentoForm.getDescricao());
        alimentoCriado.setValor(alimentoForm.getValorAlimento());
        alimentoCriado.setTipoAlimento(tipoAlimentoEntity);

        this.alimentoRepository.save(alimentoCriado);
    }


}
