package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ChurrascoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ValorPessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.ChurrascoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.ChurrascoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/churrasco")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ChurrascoController {

    private final ChurrascoService churrascoService;


//    @GetMapping("/buscarTodos")
//    public List<ChurrascoEntity> buscarTodosChurrascos (){
//        return churrascoService.buscarTodosChurrascos();
//    }

    @GetMapping("/buscarTodosPorData/{dataBusca}")
    public List<ChurrascoEntity> buscarTodosChurrascosPorData(@PathVariable String dataBusca){
        return churrascoService.buscarTodosChurrascosPorData(dataBusca);
    }

    @GetMapping("/buscarTodosEntreDuasDatas/")
    public List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(@RequestParam(name = "dataInicio") String dataBuscaInicio,
                                                                     @RequestParam(name = "dataFim") String dataBuscaFim){
        return churrascoService.buscarTodosChurrascosEntreDuasDatas(dataBuscaInicio,dataBuscaFim);
    }

//    @GetMapping("/buscarAlimentosPorValor/")
//    public List<ValorPessoaDTO> buscarAlimentosPorValor(){
//        return churrascoService.buscarAlimentosPorValor();
//    }


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
    @PostMapping(path = "/criarChurrasco")
    public void criarChurrasco(@RequestBody @Valid ChurrascoForm churrascoForm){
        this.churrascoService.criarChurrasco(churrascoForm);
    }


    // READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarChurrascos")
    public List<ChurrascoDTO> buscarChurrascos(){
        return this.churrascoService.buscarChurrascos();
    }

    // UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PostMapping(path = "/atualizarChurrasco/{id}")
    public void atualizarChurrasco(@RequestBody ChurrascoForm churrascoForm, @PathVariable Long id){
        churrascoService.atualizarChurrasco(churrascoForm, id);
    }


    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarChurrasco/{id}")
    public String deletarChurrascoPorId(@PathVariable Long id){
        churrascoService.deletarChurrascoPorId(id);
        return "Deletado";
    }


}
