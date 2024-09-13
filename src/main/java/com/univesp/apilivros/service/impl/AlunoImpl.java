package com.univesp.apilivros.service.impl;

import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlunoImpl implements AlunoService {

    @Autowired
    JdbcTemplate template;

    @Override
    public ResponseEntity<String> criaTabela(String nomeTabela) {
        template.execute("create " + nomeTabela + " (id BIGINT AUTOINCREMENT, )");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<String> listAll() {
        return null;
    }

    @Override
    public ResponseEntity<String> incluirAluno(Aluno aluno) {
        return null;
    }

    @Override
    public ResponseEntity<String> atualizarAluno(Integer id, Aluno aluno) {
        return null;
    }
}
