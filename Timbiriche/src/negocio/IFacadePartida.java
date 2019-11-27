/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.swing.Icon;

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
    public void crearPartida(String nombre, String ip, String puerto, Icon avatar);
    
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
    public boolean realizarMovimiento(Jugador jugador, ElementoJuego elementoJuego);
    
    /**
     * Este metodo permite a un jugador registrarse en la partida
     * @param jugador El jugador que desea registrarse a la partida
     * @return Partida en caso de haberse registrado a la partida con exito
     * Null en caso de no haberse podido realizar el registro
     */
    public Partida registrarJugador(Jugador jugador);
    
    /**
     * Este metodo permite eliminar un jugador de la partida, borrando todas 
     * las jugadas realizadas por el mismo
     * @param jugador El jugador que sera eliminado de la partida
     */
    public void eliminarJugador(Jugador jugador);
    
}
