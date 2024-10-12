package com.univesp.apilivros.controller;

import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.dto.AlunoDto;
import com.univesp.apilivros.service.AlunoService;
import com.univesp.apilivros.service.impl.LivroAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunoController {

    @Autowired
    AlunoService service;

    @Autowired
    LivroAlunoService livroAlunoService;

    @GetMapping
    ResponseEntity listAll(){
        return service.listAll();
    }

    @GetMapping("{id}")
    ResponseEntity findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    ResponseEntity include(@RequestBody AlunoDto aluno, UriComponentsBuilder uri){
        return service.include(aluno, uri);
    }

    @PutMapping("{id}")
    ResponseEntity update(@PathVariable ("id") Integer id,
            @RequestBody AlunoDto aluno){
        return service.update(id,aluno);
    }

    @PutMapping("/associar/{id}/{titulo}")
    ResponseEntity updateAlunoLivro(@PathVariable ("id") Integer id,
                          @PathVariable("titulo") String titulo){
        return livroAlunoService.associarLivroAoAluno(id,titulo);
    }
    @DeleteMapping("{id}")
    ResponseEntity remove(@PathVariable("id") Integer id){
        return service.remove(id);
    }

    @PutMapping("/dessasociar/{id}/{titulo}")
    ResponseEntity updateLivroAluno(@PathVariable ("id") Integer id,
                                    @PathVariable("titulo") String titulo){
        return livroAlunoService.desassociarLivroDoAluno(id, titulo);
    }
}
