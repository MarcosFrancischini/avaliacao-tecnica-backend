package br.com.cast.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", nullable = false)
    private CategoriaCurso categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_termino")
    private Date dataTermino;

    @SuppressWarnings("unused")
    public Curso() {}

    public Curso(Long id, CategoriaCurso categoria, String descricao,
                 Date dataInicio, Date dataTermino) {
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaCurso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCurso categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}

