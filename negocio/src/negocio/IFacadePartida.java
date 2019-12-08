/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javax.swing.Icon;
import static negocio.Partida.getPartida;

/**
 * Esta es la clase que sera visible para los demoas componentes del sistema 
 * timbiriche respetando asi el patron de diseño Facede para que todos los demas
 * componentes instancien su partida a partir de este metodo.
 * @author Fernando
 */
public interface IFacadePartida {
    
    /**
     * Este metodo permite crear un tablero
     * @param nombre
     * @param ip
     * @param avatar
     * @param puerto
     */
    public void crearPartida(IJugador jugador);
    
    
    /**
     * Este metodo permite a los jugadores iniciar la partida
     * @return True en caso de que la partida haya sido iniciada con exito
     */
    public boolean iniciarPartida();
    
    
    
    /**
     * Este metodo permite realizar un movimiento a un jugador registrado
     * en la partida
     * @param jugador El jugador que desea realizar el movimiento
     * @param elementoJuego El movimiento del jugador
     * @return True en caso de haberse realizado el movimiento con exito
     */
    public boolean realizarMovimiento(IJugador jugador, int i, int j);
    
    /**
     * Este metodo permite agregar un jugador a la partida
     * @param jugador El jugador que se ha unido a la partida
     */
    public boolean registrarJugador(IJugador jugador);
    
    /**
     * Este metodo permite eliminar un jugador de la partida, borrando todas 
     * las jugadas realizadas por el mismo
     * @param jugador El jugador que sera eliminado de la partida
     */
    public void eliminarJugador(IJugador jugador);
    
    /**
     * Este metodo permite a la partida enviar los jugadores que se han registrado
     * a los demas peers conectados al sistema peer to peer
     * @return 
     */
    public ArrayList enviarJugadores();
    
    /**
     * Este metodo permite recibir los jugadores que estan registrados a la partida
     * @param jugadores Los jugadores que se han registrado a la partida
     */
    public void recibirJugadores(ArrayList<IJugador> jugadores);
    
    public void setPartidaIniciada(boolean partidaIniciada);
    
    public boolean isPartidaIniciada();
    
    public boolean tienesDueno(int i, int j);
    
    public void  setDueno(IJugador jugador);

    public IJugador getDueno();
    
    public ArrayList buscarPuntos(IJugador jugador);
    
    
        
        
    
    
}
