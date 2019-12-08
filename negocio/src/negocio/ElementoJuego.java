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
 interface ElementoJuego {
    
     Jugador getOwner();
    
     void setJugador(Jugador jugador);
    
     void add(ElementoJuego elementoJuego);
    
     void remove(ElementoJuego elementoJuego);
    
     ElementoJuego getChild(int i);
    
     int getPositionX();
    
     void setPositionX(int positionX);
    
     int getPositionY();
    
     void setPositionY(int positionX);
    
}
