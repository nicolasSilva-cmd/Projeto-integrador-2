package com.univesp.apilivros.repository;

import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<List<Aluno>> findAlunoByNameContainingIgnoreCase(String nome);
}
