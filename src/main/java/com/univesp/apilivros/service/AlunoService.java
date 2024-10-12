package com.univesp.apilivros.service;

import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.dto.AlunoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


public interface AlunoService {

    ResponseEntity listAll();

    ResponseEntity findById(Integer id);
    ResponseEntity include(AlunoDto aluno, UriComponentsBuilder uri);

    ResponseEntity update(
             Integer id,
             AlunoDto aluno);

    ResponseEntity remove(Integer id);
}
