/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;

/**
 *
 * @author Fernando
 */
class Linea implements ElementoJuego, Serializable{

    private Jugador owner;
    
    private int positionX;
    private int positionY;

    Linea(Jugador owner) {
        this.owner = owner;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(ElementoJuego elementoJuego) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ElementoJuego getChild(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
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
