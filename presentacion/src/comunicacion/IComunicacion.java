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
public interface IComunicacion {
    
    public void realizarMovimiento(IJugador jugador, int x, int y);
    
    public void unirsePartida(IJugador jugador, String ip, int puerto);
    
    public void abandonarPartida(IJugador jugador);
    
    public void crearPartida(IJugador jugador) throws IOException;
    
    public void iniciarPartida(IJugador jugador);
    
    public void iniciarSerividor(IJugador jugador);

}
