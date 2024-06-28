package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.AlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.TipoAlimentoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.TipoAlimentoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.TipoAlimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tipoAlimento")
@RequiredArgsConstructor
public class TipoAlimentoController {

    private final TipoAlimentoService tipoAlimentoService;

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
    @PostMapping(path = "/criarTipoAlimento")
    public void criarTipoAlimento(@RequestBody @Valid TipoAlimentoForm tipoAlimentoForm){
        this.tipoAlimentoService.criarTipoAlimento(tipoAlimentoForm);
    }

    // READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarTiposAlimentos")
    public List<TipoAlimentoDTO> buscarTiposAlimentos(){
        return this.tipoAlimentoService.buscarTiposAlimentos();
    }

    // UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarTipoAlimento/{id}")
    public void atualizarTipoAlimento(@RequestBody TipoAlimentoForm tipoAlimentoForm,
                                      @PathVariable Long id){
        tipoAlimentoService.atualizarTipoAlimento(tipoAlimentoForm, id);
    }

    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarTipoAlimento/{id}")
    public String deletarTipoAlimento(@PathVariable Long id){
        this.tipoAlimentoService.deletarTipoAlimento(id);
        return "Deletado";
    }

}
