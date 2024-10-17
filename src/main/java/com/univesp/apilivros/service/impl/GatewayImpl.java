package com.univesp.apilivros.service.impl;

import com.univesp.apilivros.gateway.GoogleApi;
import com.univesp.apilivros.gateway.models.ApiEntity;
import com.univesp.apilivros.gateway.models.Books;
import com.univesp.apilivros.mapper.PojoMapper;
import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.dto.LivroDto;
import com.univesp.apilivros.repository.LivroRepository;
import com.univesp.apilivros.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class GatewayImpl implements GatewayService {

    @Autowired
    GoogleApi api;

    @Autowired
    LivroRepository repository;

    @Autowired
    PojoMapper mapper;

    public Books retrieveBooks(String isbn) {
        ApiEntity entity = api.getBooks(isbn);
        return new Books(entity.getItems().get(0).getVolumeInfo().getAuthor().get(0),
                entity.getItems().get(0).getVolumeInfo().getTitle(),
                entity.getTotalItems());
    }

    public ResponseEntity postIsbnBooks(String isbn, Integer quantidade){

        try{
            Books book = retrieveBooks(isbn);

            String data = new String(book.getTitulo().getBytes("utf-8"), "utf-8");
            LivroDto dto = new LivroDto(data, book.getAutor(), quantidade);
            Livro entity = mapper.livroDtoToEntity(dto);
            repository.save(entity);
            return ResponseEntity.ok(entity);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

}
