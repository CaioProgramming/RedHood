/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cacai
 */
public class Habilidade {
    int dano,custo;
    String nome;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Habilidade(int dano, String nome,int custo) {
        this.dano = dano;
        this.nome = nome;
        this.custo = custo;
    }

    public Habilidade(int dano, String nome) {
        this.dano = dano;
        this.nome = nome;
    }
    
}
