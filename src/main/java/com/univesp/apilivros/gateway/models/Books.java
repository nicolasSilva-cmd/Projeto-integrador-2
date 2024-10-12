package com.univesp.apilivros.gateway.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Books {

    private String author;
    private String title;
    private Integer totalItems;
}
