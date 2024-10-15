package com.univesp.apilivros.gateway.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Books {

    private String autor;
    private String titulo;
    private Integer quantidade;
}
