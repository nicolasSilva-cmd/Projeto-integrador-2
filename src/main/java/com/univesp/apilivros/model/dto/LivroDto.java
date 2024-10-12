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

}
