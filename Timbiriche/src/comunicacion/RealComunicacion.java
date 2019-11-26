/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import timbiriche.Jugador;
import timbiriche.Linea;
import timbiriche.Partida;

/**
 *
 * @author Fernando
 */
public class RealComunicacion implements Comunicacion{

    @Override
    public boolean realizarMovimiento(Partida partida, Linea linea) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean crearPartida(Partida partida) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Partida unirsePartida(Jugador jugador, String ip, String puerto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean abandonarPartida(Partida partida, Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
