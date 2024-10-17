package com.univesp.apilivros.service.impl;


import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.repository.AlunoRepository;
import com.univesp.apilivros.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class LivroAlunoService {

    @Autowired
    AlunoRepository repository;

    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity desassociarLivroDoAluno(Integer id, String titulo) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        Livro livro = livroRepository.findFirstByTitulo(titulo)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        if (!aluno.getLivros().contains(livro)) {
            throw new IllegalStateException("O aluno não possui este livro: " + livro.getTitulo());
        }

        aluno.getLivros().remove(livro);
        if(aluno.getLivros().isEmpty()){
            aluno.setDataEmprestimo(String.valueOf(LocalDate.of(LocalDate.now().getYear(), Month.JANUARY,01)));
            aluno.setMotivo("Sem livros.");
        }
        livro.setQuantidade(livro.getQuantidade() + 1);
        livroRepository.save(livro);
        repository.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    public ResponseEntity associarLivroAoAluno(Integer alunoId, String livroId) {
        Aluno aluno = repository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        Livro livro = livroRepository.findFirstByTitulo(livroId)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        if (livro.getQuantidade() <= 0) {
            throw new IllegalStateException("Não há exemplares disponíveis do livro: " + livro.getTitulo());
        }

        livro.setQuantidade(livro.getQuantidade() - 1);
        livroRepository.save(livro); // Atualiza a quantidade no banco de dados
        if(aluno.getLivros().isEmpty()){
            aluno.setDataEmprestimo(String.valueOf(LocalDate.now()));
            aluno.setMotivo("Leitura não finalizada.");
        }
        aluno.getLivros().add(livro);
        repository.save(aluno);
        return ResponseEntity.ok(aluno);
    }
}
