/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author Fernando
 */
class Partida implements IFacadePartida{

    ArrayList jugadores;
    Jugador turno;
    Tablero tablero;
    private static Partida partida;
    
    public Partida() {
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
    public void crearPartida(Jugador jugador) {
        jugadores.add(jugador);
        this.turno = jugador;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarJugador(Jugador jugador) {
        if(jugadores.size() == 4){
            return false;
        }else{
            jugadores.add(jugador);
        }
        return true;
    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
}
