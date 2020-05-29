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
public class Upgrade {
    String atributo;
    boolean upgraded;
    int valor;
    UpgradeInterface upgradeInterface;

    public Upgrade(String atributo, int valor, UpgradeInterface upgradeInterface) {
        this.atributo = atributo;
        this.valor = valor;
        this.upgraded = false;
        this.upgradeInterface = upgradeInterface;
    }

     public void upgrade() throws UpgradeException{
         this.upgraded = true;
         upgradeInterface.upgrade(valor,atributo);
     
     }
    
}
