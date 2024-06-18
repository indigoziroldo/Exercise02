package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ValorPessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.ChurrascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/churrasco")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ChurrascoController {

    private final ChurrascoService churrascoService;

    @GetMapping("/buscarTodos")
    public List<ChurrascoEntity> buscarTodosChurrascos (){
        return churrascoService.buscarTodosChurrascos();
    }

    @GetMapping("/buscarTodosPorData/{dataBusca}")
    public List<ChurrascoEntity> buscarTodosChurrascosPorData(@PathVariable String dataBusca){
        return churrascoService.buscarTodosChurrascosPorData(dataBusca);
    }

    @GetMapping("/buscarTodosEntreDuasDatas/")
    public List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(@RequestParam(name = "dataInicio") String dataBuscaInicio,
                                                                     @RequestParam(name = "dataFim") String dataBuscaFim){
        return churrascoService.buscarTodosChurrascosEntreDuasDatas(dataBuscaInicio,dataBuscaFim);
    }

    @GetMapping("/buscarAlimentosPorValor/")
    public List<ValorPessoaDTO> buscarAlimentosPorValor(){
        return churrascoService.buscarAlimentosPorValor();
    }


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
}
