/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import negocio.IJugador;
import negocio.Jugador;
import negocio.Linea;

/**
 *
 * @author Fernando
 */
public class Proxy implements Comunicacion{
    
    RealComunicacion rC = RealComunicacion.getInstance();

    @Override
    public void realizarMovimiento(Object elementoJuego) {
        rC.realizarMovimiento(elementoJuego);
    }

    @Override
    public void unirsePartida(Jugador jugador, String ip, int puerto) {
        rC.unirsePartida(jugador, ip, puerto);
    }

    @Override
    public void abandonarPartida(Jugador jugador) {
        rC.abandonarPartida(jugador);
    }

    
}
