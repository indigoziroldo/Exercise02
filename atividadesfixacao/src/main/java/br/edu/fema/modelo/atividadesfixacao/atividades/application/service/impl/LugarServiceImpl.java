package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.LugarEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.LugarRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.LugarDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.LugarForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.LugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LugarServiceImpl implements LugarService {

    private final LugarRepository lugarRepository;


    @Override
    @Transactional
    public void criarLugar(LugarForm lugarForm) {
        LugarEntity lugarCriado = new LugarEntity();
        lugarCriado.setVagasEstacionamento(lugarForm.getVagasEstacionamento());
        lugarCriado.setLimiteDePessoas(lugarForm.getLimiteDePessoas());
        lugarCriado.setValor(lugarForm.getValor());
        lugarCriado.getEndereco().setRua(lugarForm.getRua());
        lugarCriado.getEndereco().setNumero(lugarForm.getNumero());
        lugarCriado.getEndereco().setCep(lugarForm.getCep());
        lugarCriado.getEndereco().setCidade(lugarForm.getCidade());
        lugarCriado.getEndereco().setEstado(lugarForm.getEstado());
        lugarCriado.getEndereco().setComplemento(lugarForm.getComplemento());
        this.lugarRepository.save(lugarCriado);
    }

    @Override
    public List<LugarDTO> buscarLugares() {
        List<LugarEntity> listaLugares = this.lugarRepository.findAll();
        if (listaLugares.isEmpty()) throw new RuntimeException("lista de lugares está vazia");
        return LugarDTO.converter(listaLugares);
    }

    @Override
    public void atualizarLugar(LugarForm lugarForm, UUID id) {
        Optional<LugarEntity> lugarEncontrado = lugarRepository.findById(id);
        if (lugarEncontrado.isEmpty()) throw new RuntimeException("esse lugar não existe");
        lugarRepository.save(converterFormParaEntity(lugarForm, id));
    }

    private LugarEntity converterFormParaEntity(LugarForm formToEntity, UUID id) {
        LugarEntity lugarEntity = new LugarEntity();
        lugarEntity.setId(id);
        lugarEntity.setVagasEstacionamento(formToEntity.getVagasEstacionamento());
        lugarEntity.setLimiteDePessoas(formToEntity.getLimiteDePessoas());
        lugarEntity.setValor(formToEntity.getValor());
        lugarEntity.getEndereco().setRua(formToEntity.getRua());
        lugarEntity.getEndereco().setNumero(formToEntity.getNumero());
        lugarEntity.getEndereco().setCep(formToEntity.getCep());
        lugarEntity.getEndereco().setCidade(formToEntity.getCidade());
        lugarEntity.getEndereco().setEstado(formToEntity.getEstado());
        lugarEntity.getEndereco().setComplemento(formToEntity.getComplemento());
        return lugarEntity;
    }

    @Override
    public void deletarLugar(UUID id) {
        lugarRepository.deleteById(id);
    }
}
