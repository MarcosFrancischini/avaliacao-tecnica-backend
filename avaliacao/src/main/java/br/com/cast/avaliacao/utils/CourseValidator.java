package br.com.cast.avaliacao.utils;

import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CourseValidator {

    private CursoRepositorio repo;

    public CourseValidator(CursoRepositorio repo) {
        this.repo = repo;
    }

    public boolean validateCourse(Curso curso) {
        return validateDescriptionAndCategory(curso) && validateDate(curso);
    }

    private boolean validateDescriptionAndCategory(Curso curso) {
        return curso.getDescricao() != null && curso.getCategoria() != null;
    }

    private boolean validateDate(Curso curso) {
        return isPeriodNotNull(curso) && checkPeriodBeginningAndEnd(curso);
    }

    public boolean validatePeriod(Curso curso) {
        Iterable<Curso> cursos = repo.findAll();
        Date inicio = curso.getDataInicio();

        for(Curso course : cursos) {
            if(inicio.after(course.getDataInicio()) &&
                    inicio.before(course.getDataTermino())) {
                return false;
            }
        }
        return true;
    }

    private boolean isPeriodNotNull(Curso curso) {
        return curso.getDataInicio() != null && curso.getDataTermino() != null;
    }

    private boolean checkPeriodBeginningAndEnd(Curso curso) {
        Date hoje = new Date();
        Date inicio = curso.getDataInicio();
        Date termino = curso.getDataTermino();

        return inicio.after(hoje) && termino.after(inicio);
    }
}
