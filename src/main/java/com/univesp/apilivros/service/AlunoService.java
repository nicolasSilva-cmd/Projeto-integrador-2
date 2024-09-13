package com.univesp.apilivros.service;

import com.univesp.apilivros.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AlunoService {


    @GetMapping
    ResponseEntity<String> criaTabela(@RequestBody String nomeTabela);

    @GetMapping
    ResponseEntity<String> listAll();

    @GetMapping
    ResponseEntity<String> incluirAluno(@RequestBody Aluno aluno);

    @PostMapping
    ResponseEntity<String> atualizarAluno(
            @PathVariable ("id") Integer id,
            @RequestBody Aluno aluno);
}
