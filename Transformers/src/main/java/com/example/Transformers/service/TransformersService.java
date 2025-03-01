package com.example.Transformers.service;

import com.example.Transformers.model.Transformers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Transformers.repository.TransformersRepository;

import java.util.List;

@Service
@Transactional
public class TransformersService {

    @Autowired
    private TransformersRepository repository;

    public Transformers add (Transformers transformers){
        return repository.save(transformers);
    }

    public List<Transformers> list (){
        return repository.findAll();
    }

    public Transformers update(Integer id, Transformers updateTransformers) {
        updateTransformers.setId(id);
        return repository.save(updateTransformers);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}


