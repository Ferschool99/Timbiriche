/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import comunicacion.Forwarder;
import comunicacion.Recceiver;
import java.io.IOException;
import java.util.ArrayList;
import negocio.ConcreateCreator;
import negocio.Creator;
import negocio.IFacadePartida;
import negocio.IJugador;
import negocio.Jugador;

/**
 *
 * @author Fernando
 */
public class Tester {

    public static void enviarPaquete(Jugador jugador, ArrayList paquete) throws IOException{
       Forwarder f = new Forwarder("127.0.0.1", 9000);
       f.enviarPaquete(paquete);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Creator creador = new ConcreateCreator();
        
        IJugador jugador = (IJugador) creador.factoryMethod("Jugador");
        
        IFacadePartida partida = (IFacadePartida) creador.factoryMethod("Partida");
        
        
        jugador.setNombre("Fernando");
        
        
        ArrayList<Object> paquete = new ArrayList();
        
        paquete.add("Unirse");
        paquete.add(jugador);
        
        Recceiver r = new Recceiver(9000);
        
        r.esperarPaquete();
        
        enviarPaquete(null, paquete);
        
        enviarPaquete(null, paquete);
        
    }
    
}
