package singleton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author murilodio
 */
public class SingletonLazyHolder {
    private static class InstanceHolder{
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }
    
    private SingletonLazyHolder(){
        super();
    }
    
    public static SingletonLazyHolder getIntancia(){
        return InstanceHolder.instancia;
    }
}
