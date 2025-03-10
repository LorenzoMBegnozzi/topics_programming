package com.example.livro.repository;

import com.example.livro.Enuns.StatusLivro;
import com.example.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByStatusLivro(StatusLivro status);
}

