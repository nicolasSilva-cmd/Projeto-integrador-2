package com.univesp.apilivros.service;

import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.dto.LivroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LivroService {

    ResponseEntity listAll();

    ResponseEntity create(LivroDto livro);
    ResponseEntity update(String titulo,
                          Integer quantidade);

    ResponseEntity findById(String titulo);
    ResponseEntity findByAutor(String autor);

    ResponseEntity delete(String titulo);


}
