package com.univesp.apilivros.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class LivroId implements Serializable {

    private String titulo;
    private String autor;
}
