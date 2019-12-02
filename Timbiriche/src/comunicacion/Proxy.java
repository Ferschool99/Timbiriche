/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.IOException;
import negocio.IJugador;
import negocio.Jugador;
import negocio.Linea;

/**
 *
 * @author Fernando
 */
class Proxy implements IComunicacion{
    
    RealComunicacion rC = RealComunicacion.getInstance();

    @Override
    public void realizarMovimiento(Object elementoJuego) {
        rC.realizarMovimiento(elementoJuego);
    }

    @Override
    public void unirsePartida(IJugador jugador, String ip, int puerto) {
        rC.unirsePartida(jugador, ip, puerto);
    }

    @Override
    public void abandonarPartida(IJugador jugador) {
        rC.abandonarPartida(jugador);
    }

    @Override
    public void crearPartida(IJugador jugador) throws IOException {
        rC.crearPartida(jugador);
    }

    @Override
    public void iniciarPartida(IJugador jugador) {
        rC.iniciarPartida(jugador);
    }

}
