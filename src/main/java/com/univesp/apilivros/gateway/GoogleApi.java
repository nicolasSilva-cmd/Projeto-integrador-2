package com.univesp.apilivros.gateway;

import com.univesp.apilivros.gateway.models.ApiEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GoogleApi {
    public ApiEntity getBooks(String isbn) {
        RestClient restClient = RestClient.create();
        ApiEntity result = restClient
                .get()
                .uri("https://www.googleapis.com/books/v1/volumes?q=isbn={isbn}", isbn)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ApiEntity.class);
        return result;
    }
}
