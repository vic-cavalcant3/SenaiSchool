package com.school.senai.Service;

import com.school.senai.Interface.AlunoRepository;
import com.school.senai.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodos(){
        return repository.findAll();
    }

    public Aluno salvar(Aluno alunos){
        return repository.save(alunos);
    }

    public void excluirAluno(Long id){
        repository.deleteById(id);
    }

    public Aluno buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
}
