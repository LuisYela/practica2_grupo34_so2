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
public class Barbero extends Thread {
    private Salon salonDeCorte;
    
    public Barbero(Salon salonDeCorte){
        super("Barbero");
        this.salonDeCorte=salonDeCorte;
    }
    
    public void run(){
        while(true){
            salonDeCorte.atenderCliente();
            
            try{
                Thread.sleep( (int)(Math.random()*300001) );
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
            System.err.println("Barbero finalizo de atender un cliente");
        }
    }
}
