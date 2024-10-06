package com.univesp.apilivros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@IdClass(LivroId.class)
@Getter
public class Livro {

    @Id
    private String titulo;

    @Id
    private String autor;

    private Integer quantidade;

    public void setQuantidade(Integer quantidade) {
        if(quantidade != null) this.quantidade = quantidade;
    }


}
