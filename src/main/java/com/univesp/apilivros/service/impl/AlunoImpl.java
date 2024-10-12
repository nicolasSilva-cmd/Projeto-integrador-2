package com.univesp.apilivros.service.impl;

import com.univesp.apilivros.mapper.PojoMapper;
import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.LivroId;
import com.univesp.apilivros.model.dto.AlunoDto;
import com.univesp.apilivros.model.dto.LivroDto;
import com.univesp.apilivros.repository.AlunoRepository;
import com.univesp.apilivros.repository.LivroRepository;
import com.univesp.apilivros.service.AlunoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoImpl implements AlunoService {

    @Autowired
    JdbcTemplate template;

    @Autowired
    AlunoRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    PojoMapper mapper;

    @Override
    public ResponseEntity listAll() {
        List<Aluno> alunos = repository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @Override
    public ResponseEntity findById(Integer id) {
        Optional<Aluno> aluno = repository.findById(id);
        if(aluno.isEmpty()){
            throw new EntityNotFoundException("Aluno não encontrado, procure por outro id");
        }
        return ResponseEntity.ok(aluno);
    }

    @Override
    public ResponseEntity include(AlunoDto aluno, UriComponentsBuilder uri) {

        if(aluno.getLivros() != null && !aluno.getLivros().isEmpty()) {
            for (LivroDto livro : aluno.getLivros()) {
                Livro livroExistente = livroRepository.findLivroByTitulo(livro.getTitulo())
                        .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado: " + livro.getTitulo()));

                LivroDto livroDtoExistente = mapper.livroEntityToDto(livroExistente);
                if (livroDtoExistente.getQuantidade() <= 0) {
                    throw new IllegalStateException("Não há exemplares disponíveis do livro: " + livroExistente.getTitulo());
                }

                livroDtoExistente.setQuantidade(livroExistente.getQuantidade() - 1);
                livroRepository.save(mapper.livroDtoToEntity(livroDtoExistente));
            }
            var url = uri.path("/alunos/{id}").buildAndExpand("alunos.getId").toUri();

            return ResponseEntity.ok().location(url).build();
        }
        Aluno entity = repository.save(mapper.alunoDtoToEntity(aluno));

        var url = uri.path("/alunos").build().toUri();

        return ResponseEntity.status(201).location(url).body(entity);
    }

    @Override
    public ResponseEntity update(Integer id, AlunoDto aluno) {
        Aluno entity = repository.getReferenceById(id);
        if(entity == null){
            throw new EntityNotFoundException("Aluno não encontrado, procure por outro id");
        }
        entity.setName(aluno.getName());
        entity.setSerie(aluno.getSerie());
        entity.setDataEmprestimo(aluno.getDataEmprestimo());
        entity.setMotivo(aluno.getMotivo());
        repository.save(entity);
        return ResponseEntity.status(201).body(aluno);

    }

    @Override
    public ResponseEntity remove(Integer id) {
        Aluno aluno = repository.getReferenceById(id);
        if(aluno == null){
            throw new EntityNotFoundException("Aluno não encontrado, procure por outro id");
        }
        repository.delete(aluno);
        return ResponseEntity.noContent().build();
    }



}
