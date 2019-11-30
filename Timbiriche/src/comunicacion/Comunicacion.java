/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.util.ArrayList;
import negocio.Jugador;
import negocio.Linea;

/**
 *
 * @author Fernando
 */
public interface Comunicacion {
    
    public void realizarMovimiento(Linea linea);
    
    public void enviarJugadores(ArrayList jugadores);
    
    public void recibirJugadores(ArrayList jugadores);
    
    public void unirsePartida(Jugador jugador, String ip, String puerto);
    
    public void abandonarPartida(Jugador jugador);

}
