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
public class BarberoDormilon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Salon salonDeCorte= new Salon();//Salon compartida usada por los hilos
        
        Cliente cliente=new Cliente(salonDeCorte);
        Barbero barbero=new Barbero(salonDeCorte);
        cliente.start();
        barbero.start();
    }
    
}
