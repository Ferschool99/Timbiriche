/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Fernando
 */
public interface ElementoJuego {
    
    public Jugador getOwner();
    
    public void setJugador(Jugador jugador);
    
    public void add(ElementoJuego elementoJuego);
    
    public void remove(ElementoJuego elementoJuego);
    
    public ElementoJuego getChild(int i);
    
    public int getPositionX();
    
    public void setPositionX(int positionX);
    
    public int getPositionY();
    
    public void setPositionY(int positionX);
    
}
