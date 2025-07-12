package com.school.senai.Service;

import com.school.senai.Interface.EscolaRepository;
import com.school.senai.Model.Escola;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EscolaService {
    private final EscolaRepository repository;

    public EscolaService(EscolaRepository repository) {
        this.repository = repository;
    }

    public List<Escola> listarTodos(){
        return repository.findAll();
    }

    public Escola salvar(Escola escola){
        return repository.save(escola);
    }

    public void excluirEscola(Long id){
        repository.deleteById(id);
    }

    public Escola buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
}
