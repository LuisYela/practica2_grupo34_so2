/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author YELA
 */
public class Naveuno  extends JLabel{
    int posX;
    int posY;
    int velocidad;
    int danio;
    int ancho;
    int alto;
    
    public Naveuno() {
        
    }
    
    /**
     * Metodo para crear jugadores y enemigos
     * @param posix posicion en x donde se situa la nave
     * @param posiy posicion en y donde se situa la nave
     * @param v velocidad a la que se movera la nave
     * @param jugador si se envia true es jugador si se envia false el enemigo
     */
    public Naveuno(int posix, int posiy, int v, boolean jugador){
        this.posX=posix;
        this.posY=posiy;
        this.velocidad=v;
        this.danio=0;
        try {
            if(jugador){
                //this.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\javye\\OneDrive\\Documentos\\NetBeansProjects\\SpaceInvadersY\\imagenNave1.jpg")));
                this.setBounds(posix ,posiy, 55, 55);
                this.setOpaque(true);
                this.setBackground(Color.ORANGE);
            }else{
                //this.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\javye\\OneDrive\\Documentos\\NetBeansProjects\\SpaceInvadersY\\imagenNave1.jpg")));
                this.setBounds(posix ,posiy, 35, 50);
                this.setOpaque(true);
                this.setBackground(Color.magenta);
            }
            
        } catch (Exception e) {
            System.out.println("Juego.Disparo"+e.getMessage());
        }
    }
    
    /**
     * metodo para crear disparos
     * @param posix posicion en x de la bala
     * @param posiy posicion en y de la bala
     */
    public Naveuno(int posix, int posiy, int v){
        this.posX=posix;
        this.posY=posiy;
        try{
            this.setBounds(posix ,posiy, 15, 15);
            this.setOpaque(true);
            this.setBackground(Color.RED);
            this.velocidad = v;
        }catch (Exception e) {
            System.out.println("Juego.Disparo"+e.getMessage());
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }
    
}
