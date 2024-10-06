package com.univesp.apilivros.controller;

import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.service.impl.LivroImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroImpl service;

    @GetMapping
    ResponseEntity listAll(){
     return service.listAll();
    }

    @GetMapping("{titulo}")
    ResponseEntity findById(@PathVariable("titulo") String titulo){
        return service.findById(titulo);
    }

    @PostMapping
    ResponseEntity create(@RequestBody Livro livro){
        return service.create(livro);
    }

    @PutMapping("{titulo}")
    ResponseEntity update(@PathVariable("titulo") String titulo,
                          @PathParam("quantidade") Integer quantidade){
        return service.update(titulo, quantidade);
    }

    @DeleteMapping("{titulo}")
    ResponseEntity delete(@PathVariable("titulo") String titulo){
        return service.delete(titulo);
    }

}
