package br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.controller;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.LugarDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.ChurrascoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.LugarForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.LugarService;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/lugar")
@RequiredArgsConstructor
public class LugarController {

    private final LugarService lugarService;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarLugar")
    public void criarLugar(@RequestBody @Valid LugarForm lugarForm){
        this.lugarService.criarLugar(lugarForm);
    }

    // READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarLugares")
    public List<LugarDTO> buscarLugares(){
        return this.lugarService.buscarLugares();
    }

    // UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarLugar/{id}")
    public void atualizarLugar(@RequestBody LugarForm lugarForm, @PathVariable UUID id){
        lugarService.atualizarLugar(lugarForm, id);
    }

    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarLugar/{id}")
    public String deletarLugar(@PathVariable UUID id){
        lugarService.deletarLugar(id);
        return "Deletado";
    }


}
