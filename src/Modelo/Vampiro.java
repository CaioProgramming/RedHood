package Modelo;

import java.util.ArrayList;

public class Vampiro extends Inimigo{

    public Vampiro(String nome, int vida, int mana, int magia, int dano) {
        super(nome, vida, mana, magia, dano);
    }

   

    @Override
     ArrayList<Habilidade> habilidades() {
      return new ArrayList<Habilidade>() {{
          add(new Habilidade(25, "Chute imortal"));
          add(new Habilidade(50 + (getMagia()/2), "Garra amaldiçoada"));
          add(new Habilidade(100, "Mordida vampiresca")); 
    }};
    }

}
