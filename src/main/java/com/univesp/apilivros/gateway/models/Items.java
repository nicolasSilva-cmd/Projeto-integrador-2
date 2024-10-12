package com.univesp.apilivros.gateway.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Items {

    @JsonAlias("volumeInfo")
    private VolumeInfo volumeInfo;
}


