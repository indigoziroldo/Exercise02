package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.AlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.AlimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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



    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarAlimento")
    public void criarAlimento(@RequestBody @Valid AlimentoForm alimentoForm){
        this.alimentoService.criarAlimento(alimentoForm);
    }

    // READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarAlimentos")
    public List<AlimentoDTO> buscarTodosOsAlimentos(){
        return this.alimentoService.buscarTodosOsAlimentos();
    }

    // UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarAlimento/{id}")
    public void atualizarAlimento(@RequestBody AlimentoForm alimentoForm,
                                  @PathVariable UUID id){
        alimentoService.atualizarAlimento(alimentoForm, id);
    }

    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarAlimento/{id}")
    public String deletarAlimentoPorId(@PathVariable UUID id){
        alimentoService.deletarAlimentoPorId(id);
        return "Deletado";
    }

}
