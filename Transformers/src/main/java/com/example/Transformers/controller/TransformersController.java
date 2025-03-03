package com.example.Transformers.controller;

import com.example.Transformers.model.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Transformers.service.TransformersService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/transformers")

public class TransformersController {
    @Autowired
    public TransformersService service;

    @PostMapping()
    public ResponseEntity<Transformers> add (@RequestBody Transformers transformers){
        Transformers novoTransformers = service.add(transformers);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTransformers);
    }

    @GetMapping
    public ResponseEntity<List<Transformers>> listar(){
        List<Transformers> transformers = service.list();
        return ResponseEntity.status(HttpStatus.OK).body(transformers);
    }

    @PutMapping("/{id}")
    public Transformers update (@PathVariable Integer id, @RequestBody @Valid Transformers transformers ){
        return service.update(id, transformers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
