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
public class Item {
    String nome,field,message;
    int valor,custo,qtd;
    UpgradeInterface upgradeInterface;

    public Item(String nome, String field,String message , int valor,int custo,int qtd, UpgradeInterface upgradeInterface) {
        this.nome = nome;
        this.field = field;
        this.message = message;
        this.valor = valor;
        this.custo = custo;
        this.qtd = qtd;
        this.upgradeInterface = upgradeInterface;
    }
    
    public void consumir(){
        qtd --;
        upgradeInterface.useItem(valor, field, message);
    
    }
}
