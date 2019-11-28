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
public class ColorJugador implements IColorJugador{

    private Jugador[] jugadores = new Jugador[4];
    private Color[] colores = new Color[4];
    
    @Override
    public void coloresDefault() {
      asignarColor(jugadores[0],Color.RED);
        asignarColor(jugadores[1],Color.BLUE);
    }

    @Override
    public Color obtenerColor(Jugador jugador) {
     for (int i = 0; i < 2; i++) {
            if(jugador.equals(jugadores[i])){
                return colores[i];
            }
        }
        return null;
    }

    @Override
    public void asignarColor(Jugador jugador, Color color) {
        for (int i = 0; i < jugadores.length; i++) {
                if(jugador == jugadores[i]){
                    colores[i] = color;
                }
        }
    }
    
}
