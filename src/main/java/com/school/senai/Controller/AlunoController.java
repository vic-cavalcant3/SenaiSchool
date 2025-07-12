package com.school.senai.Controller;

import com.school.senai.Model.Aluno;
import com.school.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }
    @GetMapping
    public List<Aluno> buscarAluno(){
        return service.listarTodos();
    }

    @PostMapping
    public Aluno salvarNovoAluno(@RequestBody Aluno aluno){
        return service.salvar(aluno);
    }

    @GetMapping("/{id}")
        public Aluno buscarAlunoID(@PathVariable Long id){
            return service.buscarPorId(id);}


    @DeleteMapping("/{id}")
            public void deletarAluno(@PathVariable long id){
        service.excluirAluno(id);
        }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Aluno alunoExistente = service.buscarPorId(id);
        if(alunoExistente == null) return null;

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setEmail(alunoAtualizado.getEmail());
        alunoExistente.setTelefone(alunoAtualizado.getTelefone());
        return service.salvar(alunoExistente);

    }


    }
