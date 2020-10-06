/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author YELA
 */
public class Jugador  extends Naveuno{
    boolean moviendoDer;
    boolean moviendoIzq;

    public boolean getMoviendoDer() {
        return moviendoDer;
    }

    public void setMoviendoDer(boolean moviendoDer) {
        this.moviendoDer = moviendoDer;
    }

    public boolean getMoviendoIzq() {
        return moviendoIzq;
    }

    public void setMoviendoIzq(boolean moviendoIzq) {
        this.moviendoIzq = moviendoIzq;
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
    
    public Jugador(int x, int y, int v){
        super(x,y,v,true);
        this.moviendoDer = false;
        this.moviendoIzq = false;
    }
    
    public int nuevax(boolean dir){
        if (dir) {
            this.setPosX(this.getPosX() + this.getVelocidad());
            return this.getPosX() + this.getVelocidad();
        }else{
            this.setPosX(this.getPosX() - this.getVelocidad());
            return this.getPosX() - this.getVelocidad();
        }
    }
}
