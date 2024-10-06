package com.univesp.apilivros.service.impl;

import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.repository.LivroRepository;
import com.univesp.apilivros.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Override
    public ResponseEntity listAll() {
        List<Livro> livro = repository.findAll();
        return ResponseEntity.status(200).body(livro);
    }

    @Override
    public ResponseEntity create(Livro livro) {
        Livro entity = repository.save(livro);
        return ResponseEntity.status(201).body(entity);
    }

    @Override
    public ResponseEntity update(String titulo, Integer quantidade) {
        Livro entity = repository.findLivroByTitulo(titulo)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado, busque por outros títulos"));
        entity.setQuantidade(quantidade);
        repository.save(entity);
        return ResponseEntity.status(201).body(entity);
    }

    @Override
    public ResponseEntity findById(String titulo) {
        Livro entity = repository.findLivroByTitulo(titulo).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado, busque por outros títulos"));
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity delete(String titulo) {
        return ResponseEntity.noContent().build();
    }
}
