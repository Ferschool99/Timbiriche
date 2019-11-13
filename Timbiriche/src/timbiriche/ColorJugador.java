/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import java.awt.Color;

/**
 *
 * @author fer_p
 */
public class ColorJugador {
    
    private Jugador[] jugadores = new Jugador[4];
    private Color[] colores = new Color[4];
    
    ColorJugador(Jugador[] jugadores){
        this.jugadores = jugadores;
        coloresDefault();
        
    }
    
    private void coloresDefault(){
        asignarColor(jugadores[0],Color.RED);
        asignarColor(jugadores[1],Color.BLUE);
    }
    
    public void asignarColor(Jugador jugador, Color color){
        for (int i = 0; i < jugadores.length; i++) {
                if(jugador == jugadores[i]){
                    colores[i] = color;
                }
        }
    }
    
    public Color obtenerColor(Jugador jugador){
        for (int i = 0; i < 2; i++) {
            if(jugador.equals(jugadores[i])){
                System.out.println("Se busco el: "+jugador.getName());
                return colores[i];
            }
        }
        return null;
    }
    
}
