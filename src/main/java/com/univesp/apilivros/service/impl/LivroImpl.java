package com.univesp.apilivros.service.impl;

import com.univesp.apilivros.mapper.PojoMapper;
import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.dto.LivroDto;
import com.univesp.apilivros.repository.LivroRepository;
import com.univesp.apilivros.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Autowired
    PojoMapper mapper;

    @Override
    public ResponseEntity listAll() {
        List<Livro> livro = repository.findAll();
        return ResponseEntity.status(200).body(livro);
    }

    @Override
    public ResponseEntity create(LivroDto livro) {
        if(!livro.getAutor().isBlank() & !livro.getTitulo().isBlank() & livro.getQuantidade() != null) {
            Livro entity = repository.save(mapper.livroDtoToEntity(livro));
            return ResponseEntity.status(201).body(entity);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity update(String titulo, Integer quantidade) {
        Livro entity = repository.findFirstByTitulo(titulo)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado, busque por outros títulos"));
        entity.setQuantidade(quantidade);
        repository.save(entity);
        return ResponseEntity.status(201).body(entity);
    }

    @Override
    public ResponseEntity findById(String titulo) {
        Optional<List<Livro>> entity = repository.findLivroByTituloContainingIgnoreCase(titulo);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("Livro não encontrado, busque por outros títulos");
        }
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity findByAutor(String autor) {
        Optional<List<Livro>> entity = repository.findLivroByAutorContainingIgnoreCase(autor);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Livro não encontrado, busque por outros autores");
        }
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity delete(String titulo) {
        Livro livro = repository.findFirstByTitulo(titulo).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        repository.delete(livro);
        return ResponseEntity.noContent().build();
    }
}
