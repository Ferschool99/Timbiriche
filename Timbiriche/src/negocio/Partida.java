/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import comunicacion.ConcreateCreatorComunicacion;
import comunicacion.IComunicacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.FrmSalaEspera;

/**
 *
 * @author Fernando
 */
class Partida implements IFacadePartida{

    ArrayList jugadores;
    Jugador turno;
    Tablero tablero;
    
    boolean partidaIniciada = false;
    
    ConcreateCreatorComunicacion fabrica = new ConcreateCreatorComunicacion();
    
    private static Partida partida;
    
    private Partida() {
        this.jugadores = new ArrayList();    
        
    }
    
    /**
     *
     * @return
     */
    public static Partida getPartida()
    {
        if(partida==null)
        {
            partida = new Partida();
        }
        else
        {
            return partida;
        }
        
        return partida;
    }
    
    @Override
    public void crearPartida(IJugador jugador) {
        jugadores.add((Jugador)jugador);
        IComunicacion proxy = (IComunicacion) fabrica.FactoryMethod("Proxy");
        try {
            proxy.crearPartida(jugador);
        } catch (IOException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean iniciarPartida() {
        if(jugadores.size() >= 2){
            tablero = new Tablero((jugadores.size()*10),(jugadores.size()*10));
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean realizarMovimiento(Jugador jugador, ElementoJuego elementoJuego) {
        System.out.println("Le hablo a arealizar movimiento de la partida");
        return true;
    }

    @Override
    public boolean registrarJugador(IJugador jugador) {
        System.out.println("Le hablo a registrar jugador de la partida");
        if(jugadores.size() == 4){
            return false;
        }else{
            jugadores.add(jugador);
        }
        return true;
    }

    @Override
    public void eliminarJugador(IJugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList enviarJugadores() {
        return jugadores; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirJugadores(ArrayList<IJugador> jugadores) {
        this.jugadores = jugadores;
        if(!partidaIniciada){
            FrmSalaEspera frm = FrmSalaEspera.obtenerInstancia(null);
            frm.setJugadores(jugadores);
        }
    }

    @Override
    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    @Override
    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }
    
    
    
}
