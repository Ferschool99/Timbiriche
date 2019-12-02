/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.util.ArrayList;
import negocio.ConcreateCreatorNegocio;
import negocio.Creator;
import negocio.ElementoJuego;
import negocio.IFacadePartida;
import negocio.IJugador;
import negocio.Jugador;
import negocio.Linea;
import comunicacion.IComunicacion;

/**
 *
 * @author Fernando
 */
public class Tester {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ConcreateCreatorNegocio creador = new ConcreateCreatorNegocio();
        
        IComunicacion c = (IComunicacion) creador.factoryMethod("Proxy");
        
        IJugador jugador = (IJugador) creador.factoryMethod("Jugador");
        
        IFacadePartida partida = (IFacadePartida) creador.factoryMethod("Partida");
        
        
        jugador.setNombre("Fernando");
        jugador.setIp("127.0.0.1");
        jugador.setPuerto(9000);
        
        ArrayList<Object> paquete = new ArrayList();
        
        paquete.add("Unirse");
        paquete.add(jugador);
        
        c.crearPartida(jugador);
        //Recceiver r = new Recceiver(9000);
        
        //r.esperarPaquete();
        
        //RealComunicacion rC = RealComunicacion.getInstance();
        
        c.unirsePartida((Jugador) jugador, "127.0.0.1", 9000);
        //rC.unirsePartida((Jugador) jugador, "127.0.0.1", 9000);
        
        
        jugador.setNombre("Mauricio");
        c.unirsePartida((Jugador) jugador, "127.0.0.1", 9000);
        //rC.unirsePartida((Jugador) jugador, "127.0.0.1", 9000);
        
        
        //rC.abandonarPartida((Jugador) jugador);
        c.abandonarPartida((Jugador) jugador);
        
        ElementoJuego eL = new Linea((Jugador) jugador);
        
        //rC.realizarMovimiento(eL);
        c.realizarMovimiento(eL);
        
    }
    
}
