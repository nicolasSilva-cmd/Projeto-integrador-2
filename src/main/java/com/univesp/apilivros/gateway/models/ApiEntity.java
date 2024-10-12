package com.univesp.apilivros.gateway.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ApiEntity {

    @JsonAlias("items")
    private List<Items> items;

    @JsonAlias("totalItems")
    private Integer totalItems;
}
