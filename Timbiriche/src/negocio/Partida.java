/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author Fernando
 */
public class Partida implements IFacadePartida{

    ArrayList jugadores;
    Jugador turno;
    Tablero tablero;
    
    public Partida() {
        this.jugadores = new ArrayList();
        jugadores.add(jugador);
        this.turno = jugador;
    }
    
    @Override
    public void crearPartida(String nombre, String ip, String puerto, Icon avatar) {
        
    }

    @Override
    public boolean iniciarPartida() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean realizarMovimiento(Jugador jugador, ElementoJuego elementoJuego) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Partida registrarJugador(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
