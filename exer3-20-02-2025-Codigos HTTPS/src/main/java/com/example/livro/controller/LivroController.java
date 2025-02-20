package com.example.livro.controller;

import com.example.livro.model.Livro;
import com.example.livro.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    public LivroService service;

    @PostMapping()
    public ResponseEntity<Livro> adicionar(@RequestBody Livro livro) {
        Livro novoLivro= service.adicionar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(livros);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Integer id, @RequestBody @Valid Livro livro) {
        return service.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        service.remover(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
