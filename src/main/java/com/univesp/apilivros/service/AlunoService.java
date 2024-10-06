package com.univesp.apilivros.service;

import com.univesp.apilivros.model.Aluno;
import org.springframework.http.ResponseEntity;


public interface AlunoService {

    ResponseEntity listAll();

    ResponseEntity findById(Integer id);
    ResponseEntity include(Aluno aluno);

    ResponseEntity update(
             Integer id,
             Aluno aluno);

    ResponseEntity remove(Integer id);
}
