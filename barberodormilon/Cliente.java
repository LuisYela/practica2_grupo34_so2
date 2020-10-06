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
public class Cliente extends Thread {
    private Salon salonDeCorte;
    
    public Cliente(Salon salonDeCorte){
        super("Cliente");
        this.salonDeCorte=salonDeCorte;
    }


    public void run(){
        while(true){
            try{
                Thread.sleep( (int)(Math.random()*100001) );
                salonDeCorte.agregarCliente();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
