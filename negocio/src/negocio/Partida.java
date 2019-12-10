/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
class Partida implements IFacadePartida{

    ArrayList jugadores;
    Jugador turno;
    Tablero tablero;
    Jugador dueno;
    int numTurn = 0;
    
    boolean partidaIniciada = false;
    
    
    
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
        
    }

    @Override
    public boolean iniciarPartida() {
        if(jugadores.size() >= 2){
            tablero = new Tablero((jugadores.size()*10),(jugadores.size()*10));
            System.out.println("INICIA LA PARTIDAAAAA");
        }else{
            return false;
        }
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
        for (int i = 0; i < jugadores.size()-1; i++) {
            if(((Jugador)jugadores.get(i)).equals(jugador))
            {
                jugadores.remove(i);
                tablero.eliminarLineas((Jugador) jugador);
            }
        }
    }

    @Override
    public ArrayList enviarJugadores() {
        return jugadores; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirJugadores(ArrayList<IJugador> jugadores) {
        this.jugadores = jugadores;
        
    }

    @Override
    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    @Override
    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    @Override
    public boolean tienesDueno(int i, int j) {
        if(tablero.obtenerLinea()[i][j]!=null)
        {
                if(tablero.obtenerLinea()[i][j].getOwner()==null)
                {
                    return true;
                }
                else 
                {
                    return false;
                }
        }
        else
        {
            System.out.println("No existen lineas");
            return true;
        }
    }

    @Override
    public boolean realizarMovimiento(IJugador jugador, int i, int j) {
        System.out.println("REALIZAR MOVI");
        turno = (Jugador) jugadores.get(numTurn);
        if(jugador.equals(turno))
        {
            if(tablero.crearLinea((Jugador) jugador, i, j))
            {
                System.out.println("se creo linea 5578");
                numTurn++;
                if(numTurn==jugadores.size()) numTurn=0;
                turno = (Jugador) jugadores.get(numTurn);
                return true;
            }
            else
            {
                System.out.println("no se creo linea 5578");
                return false;
            }
        }
        return false;
    }

    @Override
    public void setDueno(IJugador jugador) {
        this.dueno = (Jugador) jugador;
    }

    @Override
    public IJugador getDueno() {
        return dueno;
    }

    @Override
    public ArrayList buscarPuntos(IJugador jugador) {
        return tablero.buscarPuntos((Jugador) jugador);
    }

    @Override
    public IJugador getTurno() {
        return turno;
    }

    @Override
    public void sigTurno() {
        numTurn+=1;
        if(numTurn==jugadores.size())numTurn=0;
    }

   
}
