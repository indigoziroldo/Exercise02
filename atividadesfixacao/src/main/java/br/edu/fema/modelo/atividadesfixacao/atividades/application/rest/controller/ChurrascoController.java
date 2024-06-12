package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.ChurrascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/churrasco")
@RequiredArgsConstructor
public class ChurrascoController {

    private final ChurrascoService churrascoService;

    @GetMapping
    public List<ChurrascoEntity> buscarTodosChurrasco (){
        return churrascoService.buscarTodosChurrasco();
    }



}
