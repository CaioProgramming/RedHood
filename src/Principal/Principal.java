package Principal;

import java.util.Random;
import java.util.Scanner;

import Modelo.Chapeuzinho;
import Modelo.Inimigo;
import Modelo.Lobisomem;
import Modelo.ManaException;
import Modelo.Professor;
import Modelo.UpgradeException;
import Modelo.Vampiro;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
	
	public static void main(String[] args) {
            jogo();
	}
	
	public static void jogo(){
            
                Random random = new Random();
                int defaultlife = 1000;
                int randomDmg = random.nextInt(150);
                int randomMagic = random.nextInt(100);
                int randomMana = random.nextInt(150);
                ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>() {{
                    add(new Lobisomem("Lobisomem das Montanhas", defaultlife, randomMana, randomDmg));
                    add(new Lobisomem("Lobisomem do lago", defaultlife, randomMana, randomDmg));
                    add(new Vampiro("Vampiro da taverna", defaultlife, randomMana, randomMagic,randomDmg));
                    add(new Vampiro("Vampiro das masmorras", defaultlife, randomMana, randomMagic,randomDmg));
                    add(new Professor("Professor de história", defaultlife, randomMana, randomDmg));
                    add(new Professor("Professor de programação", defaultlife, randomMana, randomDmg));
                }};
            
		introducao();
		Chapeuzinho chapeuzinho = new Chapeuzinho("Chapéuzinho das trevas", defaultlife, 100, 50, 70);
		Scanner input = new Scanner(System.in);
		Integer porcentagemDoCaminho = 0;
		
		while(porcentagemDoCaminho < 100) {
			System.out.println("Você já completou "+porcentagemDoCaminho+"% do caminho para a casa da vovózinha. O que deseja fazer?");
			System.out.println("1 - Continuar pelo caminho // 2 - Pegar um atalho");
			int opcao = input.nextInt();
                    switch (opcao) {
                        case 1:
                            porcentagemDoCaminho++;
                            break;
                        case 2:
                            Inimigo inimigo = inimigos.get(random.nextInt(inimigos.size()));
                            if (!inimigo.estaViva()) {
                                System.out.println("Ao pegar um atalho você se depara com o corpo de um " + inimigo.getNome()+ " e continua sua aventura!");
                                porcentagemDoCaminho+= 10;
                            }else{
                                System.out.println("Ao pegar um atalho você se depara com um terrível "+inimigo.getNome());
                                inimigo.listarInformacoes();
                                while (inimigo.estaViva()&& chapeuzinho.estaViva()) {
                                    int danoInimigo = inimigo.atacar();
                                    //chapeuzinho.listarOpcoes();
                                    //inimigo.listarInformacoes();
                                    chapeuzinho.listarInformacoes();
                                    int atq = input.nextInt();
                                    //System.out.println(atq);
                                    int danoChapeuzinho;
                                    try {
                                        danoChapeuzinho = chapeuzinho.atacar(atq);
                                        inimigo.receberDano(danoChapeuzinho);
                                    } catch (ManaException ex) {
                                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, ex.getMessage(),ex);
                                    }
                                    chapeuzinho.receberDano(danoInimigo);
                                    System.out.println("A batalha continua");
                                }
                                System.out.println("A batalha está completa");
                                System.out.println(inimigo.getNome() + " foi derrotado!");
                                porcentagemDoCaminho += 10;
                                chapeuzinho.listarAtributos();
                                int atributo = input.nextInt();
                                try {
                                    chapeuzinho.aumentarNivel(atributo);
                                    chapeuzinho.listarConsumiveis();
                                    int consumir = input.nextInt();
                                    chapeuzinho.consumirItem(consumir);
                                } catch (UpgradeException ex) {
                                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }  break;
                        default:
                            System.out.println("Opcao Invalida");
                            break;
                    }
		}
		if (chapeuzinho.estaViva()) System.out.println("Voce completou o caminho!! Parabéns, você venceu. Opa, mas o que é isso? Não parece ser a vovó na cama... (CONTINUA)");
	}
	
	public static void introducao() {
		System.out.println("Era uma vez, numa pequena cidade as margens da floresta, uma menina de olhos negros e louros cabelos cacheados, tão graciosa quanto valiosa.\r\n" + 
				"Um dia, com um retalho de tecido vermelho, sua mãe costurou para ela uma curta capa com capuz; ficou uma belezinha, combinando muito bem com os cabelos louros e os olhos negros da menina.\r\n" + 
				"Daquele dia em diante, a menina não quis mais saber de vestir outra roupa, senão aquela e, com o tempo, os moradores da vila passaram a chamá-la de Chapeuzinho Vermelho.");
		System.out.println("Nesse jogo, você estará no controle de Chapeuzinho Vermelho, uma maga do fogo com habilidades de luta impressionantes. Sua missão é levar a cesta de doces para a vovózinha, no caminho, você encontrará vastos desafios.");
	}
}
