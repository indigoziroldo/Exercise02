package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.AlimentoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.AlimentoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.AlimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alimento")
@RequiredArgsConstructor
public class AlimentoController {

    private final AlimentoService alimentoService;



        /*
                               C R U D
\,¯\`·-.,_                                   _,. --··,
               `´·,      ¯`-·· ´´´¯¯ ``` ·· ., -··´´¯    \.·´
        .            ,·´                                 ,.- ´              , ·' |
       	             ;   _                 _     ::::\·´              , ·'       |
        .          ;  /#º ;             ;#º`;   ``   ;         , ·'         , ·'
        .         /   `·--´      _      `·-- ´          ;   , ·'        , ·'
        .        ;¯)        ,  ` ´   ,       ( ¯ )      ;  `  -.,_  ' ·,
        .         \           ` ´¯` ´          ¯         ;      ,·'    ,·'
        .          ,' `·-                             _...-;  ,·'    ,·'
        .         ;    ,      ·:::::·                ``´¯¯;  \     \
        .        ;    /                      /    ,         ;   \:.::.\
        .        ;,,,/                     -/    /     =--¯;,·':::,·'
        .           ;                       ' ' '             ;::::'.·,
        .            ;                     /                /,.``· ´
        .             \                   ;                /
        .             ,´  ,                \           ,·'
        .            -,, -·'```···-----······\_     ,·
        .                                    /,,,/
                               C R U D
     */


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscar-todos-alimentos")
    public List<AlimentoDTO> buscarTodosOsAlimentos(){
        return this.alimentoService.buscarTodosOsAlimentos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/atualizar")
    public void criarAlimento(@RequestBody @Valid AlimentoForm alimentoForm){
        this.alimentoService.criarAlimento(alimentoForm);
    }



}
