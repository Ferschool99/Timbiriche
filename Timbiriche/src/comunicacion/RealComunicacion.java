/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Jugador;
import negocio.Linea;

/**
 *
 * @author Fernando
 */
public class RealComunicacion implements Comunicacion{

    ArrayList<Object> paquete;
    ArrayList<Jugador> jugadores;
    
   
    
    public RealComunicacion() {
        paquete = new ArrayList();
    }
    
    private void enviarPaquete(Jugador jugador, ArrayList paquete) throws IOException{
        Forwarder enviador = new Forwarder(jugador.getIp(), jugador.getPuerto());
        enviador.enviarPaquete(paquete);
    }
    
    @Override
    public void realizarMovimiento(Linea linea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarJugadores(ArrayList jugadores) {
        try {
            Forwarder f = new Forwarder("127.0.0.1", 9000);
        } catch (IOException ex) {
            Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
