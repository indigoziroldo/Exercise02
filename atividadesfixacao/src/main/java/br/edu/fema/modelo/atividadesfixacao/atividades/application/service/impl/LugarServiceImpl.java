package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.LugarRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.LugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LugarServiceImpl implements LugarService {

    private final LugarRepository lugarRepository;



}
