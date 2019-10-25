/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

/**
 *
 * @author fer_p
 */
public interface ElementoJuego {
    
    
    public void addOwner(Jugador owner);
    
    
    public Jugador getOwner();
    
    public ElementoJuego[][] obtenerCuadros();
    
    public ElementoJuego[][] obtenerLineas();
    
    
}
