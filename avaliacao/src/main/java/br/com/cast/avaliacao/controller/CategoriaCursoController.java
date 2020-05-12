package br.com.cast.avaliacao.controller;

import br.com.cast.avaliacao.model.CategoriaCurso;
import br.com.cast.avaliacao.repository.CategoriaCursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/categoria")
@CrossOrigin("http://localhost:4200")
public class CategoriaCursoController {

    @Autowired
    private CategoriaCursoRepositorio repo;

    @GetMapping(path = "/all", produces = "application/json")
    public Iterable<CategoriaCurso> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public CategoriaCurso get(@PathVariable("id") Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoriaCurso post(@RequestBody CategoriaCurso categoria) {
        return repo.save(categoria);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void put(@PathVariable("id") Long id, @RequestBody CategoriaCurso patch) {
        CategoriaCurso categoria = repo.findById(id).get();

        if(patch.getDescricao() != null) {
            categoria.setDescricao(patch.getDescricao());
        }

        repo.save(categoria);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}

