package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.PessoaAlimentoChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.PessoaAlimentoChurrascoService;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl.PessoaAlimentoChurrascoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoaAlimentoChurrasco")
public class PessoaAlimentoChurrascoController {

    private final PessoaAlimentoChurrascoServiceImpl pessoaAlimentoChurrascoServiceImpl;

    public PessoaAlimentoChurrascoController(PessoaAlimentoChurrascoServiceImpl pessoaAlimentoChurrascoServiceImpl) {
        this.pessoaAlimentoChurrascoServiceImpl = pessoaAlimentoChurrascoServiceImpl;
    }

    @GetMapping
    public List<PessoaAlimentoChurrascoEntity> teste (){
        return this.pessoaAlimentoChurrascoServiceImpl.busca();

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
    // CREATE

    // READ

    // UPDATE

    // DELETE

}
