/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.IOException;
import negocio.IJugador;

/**
 *
 * @author Fernando
 */
class Proxy implements IComunicacion{
    
    RealComunicacion rC = RealComunicacion.getInstance();

    @Override
    public void realizarMovimiento(IJugador jugador, int x, int y ) {
        rC.realizarMovimiento(jugador,x,y);
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
        System.out.println("Le hablo a iniciar partida en proxy");
        rC.iniciarPartida(jugador);
    }

    @Override
    public void iniciarSerividor(IJugador jugador) {
        rC.iniciarSerividor(jugador);
    }

}
