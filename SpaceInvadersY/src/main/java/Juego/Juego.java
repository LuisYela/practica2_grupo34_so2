/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author YELA
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PantallaPrincipal ventana =new PantallaPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("SpaceInvaders YELA");
        
        ventana.setVisible(true);
        
        
    }
    
}
