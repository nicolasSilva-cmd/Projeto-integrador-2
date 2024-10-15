package com.univesp.apilivros.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LivroDto {

    private String titulo;

    private String autor;

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
