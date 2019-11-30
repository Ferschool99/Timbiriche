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
import negocio.ElementoJuego;
import negocio.IJugador;
import negocio.Jugador;
import negocio.Linea;

/**
 *
 * @author Fernando
 */
public class RealComunicacion implements Comunicacion{

    ArrayList<Object> paquete = new ArrayList();
    ArrayList<IJugador> jugadores = new ArrayList();
    
    public static RealComunicacion instance;
    
    private RealComunicacion() {
        paquete = new ArrayList();
    }
    
    public static RealComunicacion getInstance(){
        if(instance == null){
            instance = new RealComunicacion();
        }
        return instance;
    }
    
    private void enviarPaquete(String ip, int puerto, ArrayList paquete) throws IOException{
        Forwarder enviador = new Forwarder(ip, puerto);
        enviador.enviarPaquete(paquete);
    }
    
    @Override
    public void realizarMovimiento(Object elementoJuego) {
        System.out.println("le hablo a realizar movimiento");
        paquete.clear();
        paquete.add("RegistrarMovimineto");
        paquete.add(elementoJuego);
        
        System.out.println("Entor a realizar");
        for(int i = 0; i < jugadores.size(); i++){
            
            try {
                enviarPaquete(jugadores.get(i).getIp(),jugadores.get(i).getPuerto(), paquete);
            } catch (IOException ex) {
                Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    //Este metodo le va a enviar a todos los jugadores registrados los jugadores
    public void enviarJugadores() throws IOException {
        for(int i = 0; i < jugadores.size(); i++){
            paquete.clear();
            paquete.add("RecibirJugadores");
            paquete.add(jugadores);
            enviarPaquete(jugadores.get(i).getIp(),jugadores.get(i).getPuerto(), paquete);
        }
    }

    //Este metod recibira los jugadores y los registrara
    public void recibirJugadores(ArrayList jugadores) {
        this.jugadores = jugadores;
        //Aqui le hablamos a la fachada de partida para setear los jugadores <----------------------------------------------------------------------------------------------
    }

    /**
     * Este metodo solicitara unirse a una partida, en caso de ser registrado
     * Quedara a la espera de la nueva lista de los jugadores junto con el.
     * @param jugador
     * @param ip
     * @param puerto 
     */
    @Override
    public void unirsePartida(Jugador jugador, String ip, int puerto) {
        paquete.clear();
        paquete.add("Registrar");
        paquete.add(jugador);
        try {
            enviarPaquete(ip, puerto, paquete);
        } catch (IOException ex) {
            System.out.println(ex.toString() + "No se puedo enviar el paquete, Recibir");
        }
    }

    //Este metodo solicitara abandonar la partida a los demas jugadores
    @Override
    public void abandonarPartida(Jugador jugador) {
        paquete.clear();
        paquete.add("AbandonarPartida");
        paquete.add(jugador);
        
        for(int i = 0; i < jugadores.size(); i++){
            
            try {
                enviarPaquete(jugadores.get(i).getIp(),jugadores.get(i).getPuerto(), paquete);
            } catch (IOException ex) {
                Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * Este metodo registra un jugador en la partida y manda a llamar al metodo
     * enviar jugadores para enviarle a todos lo jugadores que esten registrados
     * la lista de los jugadores.
     * @param jugador 
     */
    public void registrarJugador(IJugador jugador) {
        
        jugadores.add(jugador);
        
        try {
            enviarJugadores();
        } catch (IOException ex) {
            Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
        //Aqui le hablaresmos a la fachada de partida para eliminar el jugador <--------------------------------------------------------------------------------
       
    }
    
    public void registrarMovimiento(Object elementoJuego){
        System.out.println("Movimiento registrado xD ");
        //Aqui le hablaremos a la fachade de partida para registrar el movimiento <----------------------------------------------------------------------------
    }

}
