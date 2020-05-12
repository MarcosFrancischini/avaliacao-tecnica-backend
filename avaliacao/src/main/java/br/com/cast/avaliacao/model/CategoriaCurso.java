package br.com.cast.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categoria_cursos")
public class CategoriaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonBackReference
    private Set<Curso> cursos;

    @SuppressWarnings("unused")
    public CategoriaCurso() {}

    public CategoriaCurso(Long id, String descricao, Set<Curso> cursos) {
        this.id = id;
        this.descricao = descricao;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}

