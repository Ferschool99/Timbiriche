/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
class Cuadro implements ElementoJuego, Serializable{
    
    private Jugador owner;
    private int positionX;
    private int positionY;
    
    private ArrayList lineas;

    Cuadro(Jugador owner) {
        this.owner = owner;
        lineas = new ArrayList();
    }
    
    @Override
    public Jugador getOwner() {
        return owner;
    }

    @Override
    public void setJugador(Jugador jugador) {
       this.owner = jugador;
    }

    @Override
    public void add(ElementoJuego elementoJuego) {
        lineas.add(elementoJuego);
    }

    @Override
    public void remove(ElementoJuego elementoJuego) {
        lineas.remove(elementoJuego);
    }

    @Override
    public ElementoJuego getChild(int i) {
        return (ElementoJuego) lineas.get(i);
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    
    
    
}
