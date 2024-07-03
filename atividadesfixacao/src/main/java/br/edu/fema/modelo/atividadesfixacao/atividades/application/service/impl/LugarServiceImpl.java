package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.LugarEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.embbedable.Endereco;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.LugarRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.LugarDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.EnderecoForm;
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
        Endereco endereco = this.converterEnderecoFormParaEntity(lugarForm.getEnderecoForm());
        lugarCriado.setVagasEstacionamento(lugarForm.getVagasEstacionamento());
        lugarCriado.setLimiteDePessoas(lugarForm.getLimiteDePessoas());
        lugarCriado.setValor(lugarForm.getValor());
        lugarCriado.setEndereco(endereco);

        this.lugarRepository.save(lugarCriado);
    }

    private Endereco converterEnderecoFormParaEntity(EnderecoForm formToEntity) {
        Endereco endereco = new Endereco();
        endereco.setRua(formToEntity.getRua());
        endereco.setEstado(formToEntity.getEstado());
        endereco.setComplemento(formToEntity.getComplemento());
        endereco.setCidade(formToEntity.getCidade());
        endereco.setCep(formToEntity.getCep());
        endereco.setNumero(formToEntity.getNumero());

        return endereco;
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
        LugarEntity lugarCriado = new LugarEntity();
        Endereco endereco = this.converterEnderecoFormParaEntity(formToEntity.getEnderecoForm());
        lugarCriado.setId(id);
        lugarCriado.setVagasEstacionamento(formToEntity.getVagasEstacionamento());
        lugarCriado.setLimiteDePessoas(formToEntity.getLimiteDePessoas());
        lugarCriado.setValor(formToEntity.getValor());
        lugarCriado.setEndereco(endereco);

        return lugarCriado;
    }

    @Override
    public void deletarLugar(UUID id) {
        lugarRepository.deleteById(id);
    }
}
