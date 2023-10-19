/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.padroes.projeto;

import singleton.SingletonLazyHolder;
import singleton.SingletonEager;
import singleton.SingletonLazy;
import strategy.Comportamento;
import strategy.ComportamentoAgressivo;
import strategy.ComportamentoDefensivo;
import strategy.ComportamentoNormal;
import strategy.Robo;

/**
 *
 * @author murilodio
 */
public class LabPadroesProjeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Singleton
        SingletonLazy lazy = SingletonLazy.getIntancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getIntancia();
        System.out.println(lazy);
        
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);
        
        SingletonLazyHolder holder = SingletonLazyHolder.getIntancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getIntancia();
        System.out.println(holder);
        
        // Strategy
        
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();
        
        Robo euRobo = new Robo();
        
        euRobo.setComportamento(normal);
        euRobo.mover();
        euRobo.setComportamento(defensivo);
        euRobo.mover();
        euRobo.setComportamento(agressivo);
        euRobo.mover();
        
    }
    
}
