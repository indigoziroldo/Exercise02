package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.PessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.PessoaForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

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
    @PostMapping(path = "/criarPessoa")
    public void criarPessoa(@RequestBody @Valid PessoaForm pessoaForm){
        this.pessoaService.criarPessoa(pessoaForm);
    }

    // READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarPessoas")
    public List<PessoaDTO> buscarPessoas(){
        return this.pessoaService.buscarPessoas();
    }

    // UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarPessoa/{id}")
    public void atualizarPessoa(@RequestBody PessoaForm pessoaForm, @PathVariable Long id){
        pessoaService.atualizarPessoa(pessoaForm, id);
    }

    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarPessoa/{id}")
    public String deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return "Deletado";
    }


}
