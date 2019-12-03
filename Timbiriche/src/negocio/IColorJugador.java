/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.awt.Color;

/**
 *
 * @author Fernando
 */
public interface IColorJugador {
    
    public void coloresDefault();
    
    public Color obtenerColor(Jugador jugador);
    
    public void asignarColor(Jugador jugador, Color color);
    
}
