package com.univesp.apilivros.service;

import com.univesp.apilivros.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LivroService {

    ResponseEntity listAll();

    ResponseEntity create(Livro livro);
    ResponseEntity update(String titulo,
                          Integer quantidade);

    ResponseEntity findById(String titulo);

    ResponseEntity delete(String titulo);


}
