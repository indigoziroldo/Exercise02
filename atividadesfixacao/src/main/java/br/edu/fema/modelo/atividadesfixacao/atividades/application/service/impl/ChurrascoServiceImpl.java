package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.ChurrascoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.ChurrascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurrascoServiceImpl implements ChurrascoService {

    private final ChurrascoRepository churrascoRepository;

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascos() {
        return churrascoRepository.findAll();
    }

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascosPorData(String dataBusca) {
        LocalDateTime dataConvertida = (LocalDateTime.parse(dataBusca, formatter));
        return churrascoRepository
                .findByDataInicioGreaterThanEqual(dataConvertida);

    }

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(String dataBuscaInicio, String dataBuscaFim) {
        LocalDateTime dataConvertida1 = (LocalDateTime.parse(dataBuscaInicio, formatter));
        LocalDateTime dataConvertida2 = (LocalDateTime.parse(dataBuscaFim, formatter));
        return churrascoRepository
                .findAllByDataInicioBetween(dataConvertida1,dataConvertida2);
    }
}
