package Modelo;

public abstract class Inimigo extends Personagem
{ 

    
    
    public Inimigo(String nome, int vida, int mana, int magia, int dano) {
        super(nome, vida, mana, magia, dano);
    }
    
     public Inimigo(String nome, int vida, int mana, int dano) {
        super(nome, vida, mana, dano);
    }
    



}
