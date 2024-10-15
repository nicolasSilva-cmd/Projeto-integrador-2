package com.univesp.apilivros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(LivroId.class)
@Getter
public class Livro {

    @Id
    @NotBlank
    private String titulo;

    @Id
    @NotBlank
    private String autor;

    @NotBlank
    private Integer quantidade;

    public void setQuantidade(Integer quantidade) {
        if(quantidade != null) this.quantidade = quantidade;
    }

    public void setTitulo(String titulo) {
        if(titulo != null || !titulo.equals("")) this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if(autor != null || !autor.equals("")) this.autor = autor;
    }

}
