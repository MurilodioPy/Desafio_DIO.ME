package singleton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author murilodio
 */
public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();
    
    private SingletonEager(){
        super();
    }
    
    public static SingletonEager getInstancia(){
        return instancia;
    }
}
