package com.school.senai.Service;


import com.school.senai.Interface.ProfessorRepository;

import com.school.senai.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listarTodos(){
        return repository.findAll();
    }

    public Professor salvar(Professor professores){
        return repository.save(professores);
    }

    public void excluirProfessor(Long id){
        repository.deleteById(id);
    }

    public Professor buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
}
