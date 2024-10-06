package com.univesp.apilivros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String serie;

    private String dataEmprestimo;

    private String motivo;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Livro> livros;

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
