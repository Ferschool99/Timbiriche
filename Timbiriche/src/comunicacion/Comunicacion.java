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
public interface Comunicacion {
    /**
     * Este metodo permite realizar un movimiento en el tablero de timbiriche
     * @return regresa verdader en caso de aver efectuado el movimiento con
     * exito
     */
    public boolean realizarMovimiento(Partida partida, Linea linea);
    
    /**
     * Este metodo permite crear una partida dentro del juego de timbiriche
     * @return regresa verdadero en caso de havber creado la partida con exito
     */
    public boolean crearPartida(Partida partida);
    
    /**
     * Este metodo permite a un jugador ingresar a una partida
     * @param jugador El jugador que esta solicitando ingresar a la partida
     * @return La partida a la que se ha unido el jugador
     */
    public Partida unirsePartida(Jugador jugador, String ip, String puerto);
    
    /**
     * Este metodo permite a un jugador abandonar la partida
     * @return Regresa verdader en caso de haber realizado la operacion con
     * exito
     */
    public boolean abandonarPartida(Partida partida, Jugador jugador);

}
