package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lugar")
@RequiredArgsConstructor
public class LugarController {

    private final LugarService lugarService;


}
