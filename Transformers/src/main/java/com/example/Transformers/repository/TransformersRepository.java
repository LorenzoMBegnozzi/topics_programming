package com.example.Transformers.repository;

import com.example.Transformers.model.Transformers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformersRepository extends JpaRepository<Transformers, Integer> {

    //jpa ja inclui os metodos basicos sme precisa programar - delete, criar, buscar, atualizar
}
