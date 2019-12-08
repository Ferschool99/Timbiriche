/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
class ColorJugador implements IColorJugador{

    private ArrayList<Jugador> jugadores = new ArrayList();
    private Color[] colores = new Color[4];
    private Partida partida = (Partida) ConcreateCreatorNegocio.factoryMethod("partida");

    ColorJugador() {
        System.out.println("SE creo la clase color");
        this.jugadores =  partida.enviarJugadores();
        System.out.println(jugadores.get(0).nombre);
        System.out.println(jugadores.get(1).nombre);
        coloresDefault();
    }
    
    public void coloresDefault() {
            asignarColor(jugadores.get(0),Color.RED);
        if(jugadores.size()>=2)
            System.out.println("Color jugador 2");
            asignarColor(jugadores.get(1),Color.BLUE);
        if(jugadores.size()>=3)
             asignarColor(jugadores.get(2), Color.yellow);
        if(jugadores.size()>=4)
             asignarColor(jugadores.get(3), Color.GREEN);
    }

    @Override
    public Color obtenerColor(IJugador jugador) {
     for (int i = 0; i < jugadores.size(); i++) {
            if(jugador.getNombre().equalsIgnoreCase(jugadores.get(i).getNombre())){
                System.out.println("Enconrto color");
                return colores[i];
            }
        }
        System.out.println("No encontro color");
        return null;
    }

    @Override
    public void asignarColor(IJugador jugador, Color color) {
        for (int i = 0; i < jugadores.size(); i++) {
                if(jugador.getNombre().equalsIgnoreCase(jugadores.get(i).getNombre())){
                    colores[i] = color;
                }
        }
    }
    
}
