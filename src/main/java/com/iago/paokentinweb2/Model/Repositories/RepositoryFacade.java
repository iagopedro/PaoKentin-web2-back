package com.iago.paokentinweb2.Model.Repositories;

import com.iago.paokentinweb2.Model.Entities.Fornada;
import com.iago.paokentinweb2.Model.Entities.Pao;

import java.util.List;

public class RepositoryFacade {

    private static RepositoryFacade myself = new RepositoryFacade();
    private GenericRepository<Pao, Integer> paoRep = null;
    private GenericRepository<Fornada, Integer> fornadaRep = null;

    private RepositoryFacade() {
        this.paoRep = new PaoRepository();
        this.fornadaRep = new FornadaRepository();
    }

    public static RepositoryFacade getCurrentInstance() {
        return myself;
    }

    public void create(Pao p) {
        this.paoRep.create(p);
    }

    public void create(Fornada f) {
        this.fornadaRep.create(f);
    }

    public void update(Pao p) {
        this.paoRep.update(p);
    }

    public void update(Fornada f) {
        this.fornadaRep.update(f);
    }

    public Pao readPao(int id) {
        return this.paoRep.read(id);
    }

    public Fornada readFornada(int id) {
        return this.fornadaRep.read(id);
    }

    public void deletePao(int id) {
        this.paoRep.delete(id);
    }

    public void deleteFornada(int id) {
        this.fornadaRep.delete(id);
    }

    public List<Pao> readAllPaes(){
        return this.paoRep.readAll();
    }

    public List<Fornada> readAllFornadas(){
        return this.fornadaRep.readAll();
    }
}
