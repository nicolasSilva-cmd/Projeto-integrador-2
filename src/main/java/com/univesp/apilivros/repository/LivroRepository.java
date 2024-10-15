package com.univesp.apilivros.repository;

import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.LivroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, LivroId> {
    Optional<List<Livro>> findLivroByTituloContainingIgnoreCase(String titulo);




    Optional<Livro> findFirstByTitulo(String titulo);


    Optional<List<Livro>> findLivroByAutorContainingIgnoreCase(String autor);
}
