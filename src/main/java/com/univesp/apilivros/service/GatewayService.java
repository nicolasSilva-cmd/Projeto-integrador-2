package com.univesp.apilivros.service;

import com.univesp.apilivros.gateway.models.Books;
import org.springframework.http.ResponseEntity;

public interface GatewayService {

    Books retrieveBooks(String isbn);
    ResponseEntity postIsbnBooks(String isbn, Integer quantidade);
}
