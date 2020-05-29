/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author cacai
 */
public class MonstroMarinho extends Inimigo{

    public MonstroMarinho(String nome, int vida, int mana, int magia, int dano) {
        super(nome, vida, mana, magia, dano);
    }

    @Override
    ArrayList<Habilidade> habilidades() {
        return new ArrayList<Habilidade>() {{
          add(new Habilidade(50, "Onda estrondosa"));
          add(new Habilidade(70 + (getMagia()), "Grito sônico"));
          add(new Habilidade(100 * getDano(), "Presa fatal")); 
    }};
    }
    
}
