/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cacai
 */
public abstract class Personagem {
    private String nome;
    private int vida,magia,mana,dano;
    long delaytime = 400;
    abstract ArrayList<Habilidade> habilidades();
    
    public Personagem(String nome, int vida, int mana,int magia,int dano) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.magia = magia;
        this.dano = dano;
    }

    public Personagem(String nome, int vida, int mana, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.dano = dano;
    }
    
    

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

      public void upgradeDano(int dano) {
        this.dano += dano;
    }
    
    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }
     public void upgradeMagia(int magia) {
        this.magia += magia;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void upgradeVida(int vida) {
        this.vida += vida;
    }
    
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public void upgradeMana(int mana) {
        this.mana += mana;
    }


    public ArrayList<Habilidade> getHabilidades() {
        return habilidades();
    }

     

   
    public void vidaRestante(){
    
        System.out.println(getNome() +  ": Vida restante -> " + getVida());
    }
    
    public int atacar(){
        Habilidade h = randomAbility();
        System.out.println(getClass().getSimpleName() + " ataca com " + h.nome + " e causa " + h.dano + " de dano");
        return h.dano;
    }
    
    
     public int atacar(int atqSelecionado) throws ManaException{
         if (atqSelecionado > habilidades().size()) {
             System.out.println("Opção inválida!");
             return 0;
         }
         
       
      Habilidade h = habilidades().get(atqSelecionado - 1);
        if (h.getCusto() > getMana()) {
             throw new ManaException("Mana insuficiente para o ataque");
        }
      System.out.println(getNome() + " ataca com " + h.nome + " e causa " + h.dano + " de dano");
      setMana(getMana() - h.getCusto());
      System.out.println("Mana restante -> " +  getMana());
      return h.dano;
        
    }
    
    public void receberDano(int dano){
        try {
            Thread.sleep(delaytime);
            System.out.println(getNome() + " recebeu " + dano + " de dano");
            setVida(getVida() - dano);
        } catch (InterruptedException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
   
    
    
    
    public Habilidade randomAbility(){
        Random r = new Random();
        return getHabilidades().get(r.nextInt(habilidades().size()));
    }
    
    public void receberDano(Integer dano) {
		vida -= dano;
    
    }
    
    public boolean estaViva() {
        vidaRestante();
        return vida > 0;}
    
    
    public void listarInformacoes() {
        
        System.out.println("\n"+getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Dano: " + getDano());
        System.out.println("Mana: " + getMana());
        System.out.println("Magia: " + getMagia());
        System.out.println(habilidades().size() + " habilidades");
        listarHabilidades();
    }
    
    protected void listarHabilidades(){
        for (int i = 0; i < habilidades().size(); i++) {
            try {
                Thread.sleep(delaytime);
                Habilidade h = habilidades().get(i);
                System.out.println("\n"+(i + 1) + " -> " + h.nome + "\nDANO -> " + h.dano + "\ncusto -> " + h.custo + " de mana");
            } catch (InterruptedException ex) {
                Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
