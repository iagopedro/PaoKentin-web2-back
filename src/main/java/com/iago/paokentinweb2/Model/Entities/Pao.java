package com.iago.paokentinweb2.Model.Entities;

public class Pao {

    private int id;

    private String nome;
    private int tempoPreparo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
