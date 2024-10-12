package com.univesp.apilivros.model.dto;

import com.univesp.apilivros.model.Livro;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AlunoDto {

    private String name;
    private String serie;
    private String dataEmprestimo;
    private String motivo;
    private List<LivroDto> livros;
    public void setName(String name) {
        if(name != null) this.name = name;
    }
    public void setSerie(String serie) {
        if(serie != null) this.serie = serie;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        if(dataEmprestimo != null) this.dataEmprestimo = String.valueOf(dataEmprestimo);
    }
    public void setMotivo(String motivo) {
        if(motivo != null) {
            this.motivo = motivo;
        } else {
            this.motivo = "Sem motivo, ainda está com o livro ou não está com nenhum livro em posse.";
        }
    }
}
