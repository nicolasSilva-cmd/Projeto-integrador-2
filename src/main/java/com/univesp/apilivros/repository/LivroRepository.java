package com.univesp.apilivros.repository;

import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.LivroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, LivroId> {
    Optional<Livro> findLivroByTitulo(String titulo);
}
