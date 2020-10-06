/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberodormilon;

/**
 *
 * @author dotto
 */
public class Salon {
    private int numSillas=10;
    private int sillasOcupadas=0;
    
    public synchronized void agregarCliente(){
        System.err.println("Nuevo cliente");
                
        if(sillasOcupadas<numSillas){
            sillasOcupadas++;            
        }else{
            System.out.println("La sala de espera esta completa, el cliente se va.");
        }
        
        notify();
    }
    
    
    public synchronized void atenderCliente(){
        while(sillasOcupadas==0){
            try{
                System.err.println("La sala de espera esta vacia, el barbero espera..");
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        sillasOcupadas--;
        System.err.print("Barbero corta el pelo...");
    }
            
}
