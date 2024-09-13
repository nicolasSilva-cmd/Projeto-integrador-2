package com.univesp.apilivros.repository;

import com.univesp.apilivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
