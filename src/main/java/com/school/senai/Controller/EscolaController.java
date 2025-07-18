package com.school.senai.Controller;

import com.school.senai.Model.Escola;
import com.school.senai.Service.EscolaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    private final EscolaService service;

    public EscolaController(EscolaService service) {
        this.service = service;
    }


    @GetMapping
    public List<Escola> buscarEscola(){
        return service.listarTodos();
    }

    @PostMapping
    public Escola salvarNovaEscola(@RequestBody Escola escola){
        return service.salvar(escola);
    }

    @GetMapping("/{id}")
    public Escola buscarEscolaID(@PathVariable Long id){
        return service.buscarPorId(id);}


    @DeleteMapping("/{id}")
    public void deletarEscola(@PathVariable long id){
        service.excluirEscola(id);
    }

    @PutMapping("/{id}")
    public Escola atualizarEscola(@PathVariable Long id, @RequestBody Escola escolaAtualizado){
        Escola escolaExistente = service.buscarPorId(id);
        if(escolaExistente == null) return null;

        escolaExistente.setNome(escolaAtualizado.getNome());
        escolaExistente.setEmail(escolaAtualizado.getEmail());
        escolaExistente.setTelefone(escolaAtualizado.getTelefone());
        return service.salvar(escolaAtualizado);

    }


}
