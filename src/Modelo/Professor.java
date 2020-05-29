package Modelo;

import java.util.ArrayList;

public class Professor extends Inimigo {

    public Professor(String nome, int vida, int mana, int dano) {
        super(nome, vida, mana, dano);
    }

  
	 

    @Override
    ArrayList<Habilidade> habilidades() {
      return new ArrayList<Habilidade>() {{
          add(new Habilidade(60, "Piada ruim"));
          add(new Habilidade(30, "Sobrecarga de conhecimento"));
          add(new Habilidade(100, "Contar uma história de vida")); 
    }};
    }
	
}
