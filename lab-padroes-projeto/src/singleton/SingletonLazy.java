package singleton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author murilodio
 */
public class SingletonLazy {
    private static SingletonLazy instancia;
    
    private SingletonLazy(){
        super();
    }
    
    public static SingletonLazy getIntancia(){
        if(instancia == null){
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
