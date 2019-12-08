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
        
    public Color obtenerColor(IJugador jugador);
    
    public void asignarColor(IJugador jugador, Color color);
    
}
