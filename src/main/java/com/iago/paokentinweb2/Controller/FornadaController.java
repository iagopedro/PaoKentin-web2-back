package com.iago.paokentinweb2.Controller;

import com.iago.paokentinweb2.Model.Entities.Fornada;
import com.iago.paokentinweb2.Model.Repositories.RepositoryFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornada")
public class FornadaController {

    @PostMapping("/create")
    public String create(@RequestBody Fornada f) {
        RepositoryFacade.getCurrentInstance().create(f);

        return "Fornada cadastrada com sucesso!";
    }

    @PutMapping
    public void update(@RequestBody Fornada f) {
        RepositoryFacade.getCurrentInstance().update(f);
    }

    @GetMapping("/{id}")
    public Fornada read(@PathVariable("id") int id) {
        return RepositoryFacade.getCurrentInstance().readFornada(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        RepositoryFacade.getCurrentInstance().deleteFornada(id);
    }

    @GetMapping
    public List<Fornada> readAll() {
        return RepositoryFacade.getCurrentInstance().readAllFornadas();
    }
}
