package Modelo;

import java.util.ArrayList;

public class Lobisomem extends Inimigo {

    public Lobisomem(String nome, int vida, int mana,int dano) {
        super(nome, vida, mana, dano);
    }

	 
     @Override
     ArrayList<Habilidade> habilidades() {
      return new ArrayList<Habilidade>() {{
          add(new Habilidade(25, "Mordida canina"));
          add(new Habilidade(50, "Enterrar vivo"));
          add(new Habilidade(100, "Garras mortais")); 
    }};
    }

}
