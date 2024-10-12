package com.univesp.apilivros.gateway.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VolumeInfo {

    @JsonAlias("authors")
    private List<String> author;

    @JsonAlias("title")
    private String title;
}
