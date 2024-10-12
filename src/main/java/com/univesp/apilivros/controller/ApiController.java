package com.univesp.apilivros.controller;

import com.univesp.apilivros.gateway.models.Books;
import com.univesp.apilivros.service.GatewayService;
import com.univesp.apilivros.service.impl.GatewayImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google-api")
public class ApiController {

    @Autowired
    GatewayService service;

    @GetMapping("/")
    public ResponseEntity retrieveBooks(@PathParam("isbn") String isbn) {
        Books book = service.retrieveBooks(isbn);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/post")
    public ResponseEntity postBooks(@PathParam("isbn") String isbn,
                                    @PathParam("quantidade") Integer quantidade) {
        return service.postIsbnBooks(isbn,quantidade);
    }

}
