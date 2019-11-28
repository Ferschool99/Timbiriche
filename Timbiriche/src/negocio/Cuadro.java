/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
class Cuadro implements ElementoJuego{
    
    private Jugador owner;
    private int positionX;
    private int positionY;
    
    private ArrayList lineas;

    public Cuadro(Jugador owner) {
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    
    
    
}
