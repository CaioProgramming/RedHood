package Modelo;

import java.util.ArrayList;
import java.util.logging.Level;

public class Chapeuzinho extends Personagem implements UpgradeInterface {

    
    
    private final ArrayList<Upgrade> melhorias;
    private final ArrayList<Item> items;

    public Chapeuzinho(String nome, int vida, int mana, int magia, int dano) {
        super(nome, vida, mana, magia, dano);
        this.melhorias = new ArrayList<Upgrade>() {
            {
                add(new Upgrade("Vida", 10, Chapeuzinho.this));
                add(new Upgrade("Mana", 10, Chapeuzinho.this));
                add(new Upgrade("Dano", 2, Chapeuzinho.this));
                add(new Upgrade("Magia", 2, Chapeuzinho.this));
            }
        };

        this.items = new ArrayList<Item>() {
            {
                add(new Item("Docinho", "Mana", "Tenho que maneirar nesses docinhos, afinal, eles são para a vovó...", 40, 0, 15, Chapeuzinho.this));
                add(new Item("Fogo revigorante", "Vida","Estava precisando desse fogo para dar uma aliviada...",  100, 20, 5, Chapeuzinho.this));
                add(new Item("Maçã da floresta",  "Vida", "Essa maçã está uma delícia!", 300, 0, 10, Chapeuzinho.this));
            }
        };
    }

    @Override
    ArrayList<Habilidade> habilidades() {
        return new ArrayList<Habilidade>() {
            {
                add(new Habilidade(getDano() * 3, "Soco", 0));
                add(new Habilidade(getMagia() + getDano() *4, "Bola de fogo", 25));
                add(new Habilidade(getDano() + getMagia() * 9 , "Espada de fogo", 50));
            }
        };
    }

    private void listarMelhorias() {
        System.out.println("0 -> Continuar aventura" );
        for (int i = 0; i < melhorias.size(); i++) {
            Upgrade up = melhorias.get(i);
            String checked = up.upgraded ? "✔" : "";
            System.out.println((i + 1) + " -> + " + up.valor + up.atributo + "[" + checked + "]");
        }

    }

    public void consumirItem(int item) {
        items.get(item - 1).consumir();
    }

    public void listarAtributos() {
        System.out.println("Parabéns, escolha um atributo para melhorar: ");
        listarMelhorias();
    }
    
 

    public void listarConsumiveis() {
        System.out.println("Gostaria de consumir algo antes de prosseguir a jornada?");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ":[" + item.qtd + "]" + item.nome+"(+" + item.valor +item.field + ")");
        }
    }

    public void aumentarNivel(Integer atributo) throws UpgradeException {
        if (atributo == 0) {return;}
        if (melhorias.get(atributo - 1).upgraded) {
            throw new UpgradeException("Esse bônus já foi utilizado, perdeu o bônus dessa rodada!");
        } else if (atributo == null ||atributo > melhorias.size()) {
            throw new UpgradeException("Opção inválida, ficará sem bônus!");
        } else {
            melhorias.get(atributo - 1).upgrade();
        }
    }
    

    public void listarOpcoes() {
        System.out.println("\nHora de " + getNome() + " atacar:");
        listarHabilidades();
    }

    @Override
    public void upgrade(int value, String field) {
        switch (field) {
            case "Vida":
                upgradeVida(getVida() + value);
                break;
            case "Dano":
                upgradeDano(getDano() + value);
                break;
            case "Magia":
                upgradeMagia(getMagia() + value);
                break;

            case "Mana":
                upgradeMana(getMana() + value);
                break;
        }
        System.out.println("Parabéns você melhorou " + field);
    }

    
    
    
    
    @Override
    public void useItem(int value, String field, String message) {
        switch (field) {
            case "Vida":
                upgradeVida(value);

                break;
            case "Dano":
                upgradeDano(value);
                break;
            case "Magia":
                upgradeMagia(value);
                break;

            case "Mana":
                upgradeMana(value);
                break;
        }
        System.out.println(message);
    }

}
