package com.iago.paokentinweb2.Controller;

import com.iago.paokentinweb2.Model.Entities.Pao;

import com.iago.paokentinweb2.Model.Repositories.RepositoryFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pao")
public class PaoController {

    @PostMapping("/create")
    public String create(@RequestBody Pao p) {
        RepositoryFacade.getCurrentInstance().create(p);

        return "Pão cadastrado com sucesso!!!";
    }

    @PutMapping
    public void update(@RequestBody Pao p) {
        RepositoryFacade.getCurrentInstance().update(p);
    }

    @GetMapping("/{id}")
    public Pao read(@PathVariable("id") int id) {
        return RepositoryFacade.getCurrentInstance().readPao(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        RepositoryFacade.getCurrentInstance().deletePao(id);
    }

    @GetMapping
    public List<Pao> readAll() {
        return RepositoryFacade.getCurrentInstance().readAllPaes();
    }
}
