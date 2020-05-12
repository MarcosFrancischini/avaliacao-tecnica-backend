package br.com.cast.avaliacao.controller;

import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CategoriaCursoRepositorio;
import br.com.cast.avaliacao.repository.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/curso")
@CrossOrigin("http://localhost:4200")
public class CursoController {

    @Autowired
    private CursoRepositorio repoCurso;

    @Autowired
    private CategoriaCursoRepositorio repoCursoCategoria;

    @GetMapping(path = "/all", produces = "application/json")
    public Iterable<Curso> getAll() {
        return repoCurso.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Curso get(@PathVariable("id") Long id) {
        return repoCurso.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Curso post(@RequestBody Curso curso) {
        return repoCurso.save(curso);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void put(@PathVariable("id") Long id, @RequestBody Curso patch) {
        Curso curso = repoCurso.findById(id).get();

        if(patch.getDescricao() != null) {
            curso.setDescricao(patch.getDescricao());
        }

        if(patch.getCategoria() != null) {
            curso.setCategoria(patch.getCategoria());
        }

        if(patch.getDataInicio() != null) {
            curso.setDataInicio(patch.getDataInicio());
        }

        if(patch.getDataTermino() != null) {
            curso.setDataTermino(patch.getDataTermino());
        }

        repoCurso.save(curso);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        repoCurso.deleteById(id);
    }
}

