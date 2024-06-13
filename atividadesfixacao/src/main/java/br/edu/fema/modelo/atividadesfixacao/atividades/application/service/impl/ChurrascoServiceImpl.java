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

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascos() {
        return churrascoRepository.findAll();
    }

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascosPorData(String dataBusca) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        LocalDateTime dataConvertida = (LocalDateTime.parse(dataBusca, formatter));
        return churrascoRepository
                .findByDataInicioGreaterThanEqual(dataConvertida);

    }

}
