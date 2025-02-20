package com.example.livro.service;

import com.example.livro.model.Livro;
import com.example.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivroService {

    @Autowired
    private LivroRepository repository;


    public Livro adicionar(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public Livro atualizar(Integer id, Livro updateLivro) {

        repository.findById(id).orElseThrow();

        return repository.save(updateLivro);

    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }

}