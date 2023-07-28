package com.iago.paokentinweb2.Model.Entities;

import java.sql.Date;

public class Fornada {

    private int id;
    private Date horarioInicial;
    private Pao pao;

    public Pao getPao() {
        return pao;
    }

    public void setPao(Pao pao) {
        this.pao = pao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Date horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

}
