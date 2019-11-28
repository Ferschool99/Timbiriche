/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.util.ArrayList;
import timbiriche.Jugador;
import timbiriche.Linea;
import timbiriche.Partida;

/**
 *
 * @author Fernando
 */
public class RealComunicacion implements Comunicacion{

    ArrayList<Object> paquete;
    
    public RealComunicacion() {
        paquete = new ArrayList();
    }
    
    @Override
    public void realizarMovimiento(Linea linea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarJugadores(ArrayList jugadores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirJugadores(ArrayList jugadores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unirsePartida(Jugador jugador, String ip, String puerto) {
        paquete.clear();
        paquete.add("Unirse");
        paquete.add(jugador);
        paquete.add(ip);
        paquete.add(puerto);
    }

    @Override
    public void abandonarPartida(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
