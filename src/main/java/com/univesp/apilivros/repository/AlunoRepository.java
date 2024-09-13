package com.univesp.apilivros.repository;

import com.univesp.apilivros.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
