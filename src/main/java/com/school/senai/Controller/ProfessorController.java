package com.school.senai.Controller;

import com.school.senai.Model.Aluno;
import com.school.senai.Model.Professor;
import com.school.senai.Service.AlunoService;
import com.school.senai.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }
    @GetMapping
    public List<Professor> buscarProfessor(){
        return service.listarTodos();
    }
    @PostMapping
    public Professor salvarNovoProfessor(@RequestBody Professor professor){
        return service.salvar(professor);
    }

    @GetMapping("/{id}")
        public Professor buscarProfessorID(@PathVariable Long id){
            return service.buscarPorId(id);}


    @DeleteMapping("/{id}")
            public void deletarProfessor(@PathVariable long id){
        service.excluirProfessor(id);
        }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor ProfessorAtualizado){
        Professor professorExistente = service.buscarPorId(id);
        if(professorExistente == null) return null;

        professorExistente.setNome(ProfessorAtualizado.getNome());
        professorExistente.setEmail(ProfessorAtualizado.getEmail());
        professorExistente.setTelefone(ProfessorAtualizado.getTelefone());
        return service.salvar(professorExistente);

    }


    }
