package com.example.livro.controller;

import com.example.livro.Enuns.StatusLivro;
import com.example.livro.model.Livro;
import com.example.livro.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    public LivroService service;

    @PostMapping()
    public ResponseEntity<Livro> adicionar(@RequestBody Livro livro) {
        Livro novoLivro = service.adicionar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(livros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Integer id, @RequestBody @Valid Livro livro, StatusLivro statusLivro) {
        Livro atualizado = service.atualizar(id, livro);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        service.remover(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Livro>> listarStatus(){
        List<Livro> statusLivros = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(statusLivros);
    }

}
