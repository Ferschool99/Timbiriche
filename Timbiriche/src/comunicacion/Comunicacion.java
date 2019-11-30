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
public interface Comunicacion {
    
    public void realizarMovimiento(Object elemntoJuego);
    
    public void unirsePartida(Jugador jugador, String ip, int puerto);
    
    public void abandonarPartida(Jugador jugador);

}
