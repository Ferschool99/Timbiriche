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
import negocio.ConcreateCreatorNegocio;
import negocio.IFacadePartida;
import negocio.IJugador;
import presentacion.FrmSalaEspera;

/**
 *
 * @author Fernando
 */
class RealComunicacion implements IComunicacion{

    ArrayList<Object> paquete = new ArrayList();
    ArrayList<IJugador> jugadores = new ArrayList();
    
    ConcreateCreatorNegocio creadorNegocio = new ConcreateCreatorNegocio();
    
    IFacadePartida partida = (IFacadePartida) creadorNegocio.factoryMethod("Partida");
    
    Recceiver servidor;
    
    static RealComunicacion instance;
    
    private RealComunicacion() {
        System.out.println("Se creo la real comunication");
    }
    
    static RealComunicacion getInstance(){
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
        
        if(partida.isPartidaIniciada()){
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
        }else{
            mostrarPeticionRechazada();
        }
        
    }

    //Este metodo le va a enviar a todos los jugadores registrados los jugadores
    void enviarJugadores() throws IOException {
        
        for(int i = 0; i < jugadores.size(); i++){
            paquete.clear();
            paquete.add("RecibirJugadores");
            paquete.add(jugadores);
            enviarPaquete(jugadores.get(i).getIp(),jugadores.get(i).getPuerto(), paquete);
        }
    }

    //Este metod recibira los jugadores y los registrara
    void recibirJugadores(ArrayList jugadores) {
        System.out.println("Entro a hablarle para setear jugadores!!!");
        for (int i = 0; i < jugadores.size(); i++) {
            IJugador j = (IJugador) jugadores.get(i);
            System.out.print(j.getNombre() + " ");
        }
        System.out.println("");
        this.jugadores = jugadores;
        FrmSalaEspera frm = FrmSalaEspera.obtenerInstancia(null);
        frm.setJugadores(jugadores);
        partida.recibirJugadores(jugadores);
        
        
        if(!partida.isPartidaIniciada()){
            frm.setJugadores(jugadores);
        }
        
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
    public void unirsePartida(IJugador jugador, String ip, int puerto) {
        paquete.clear();
        paquete.add("Registrar");
        paquete.add(jugador);
        partida.setDueno(jugador);
        try {
            enviarPaquete(ip, puerto, paquete);
        } catch (IOException ex) {
            System.out.println(ex.toString() + "No se puedo enviar el paquete, Recibir");
        }
    }

    //Este metodo solicitara abandonar la partida a los demas jugadores
    @Override
    public void abandonarPartida(IJugador jugador) {
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
    void registrarJugador(IJugador jugador) throws IOException {
        System.out.println("Entro a rC a registrar a " + jugador.getNombre());
        
        IFacadePartida p = (IFacadePartida) ConcreateCreatorNegocio.factoryMethod("partida");
        jugadores = p.enviarJugadores();
        
        if(jugadores.size()<4){
            jugadores.add(jugador);
        
            try {
                enviarJugadores();
            } catch (IOException ex) {
                Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            rechazarPeticion(jugador);
        }
    }

    void eliminarJugador(IJugador jugador) {
        jugadores.remove(jugador);
        //Aqui le hablaresmos a la fachada de partida para eliminar el jugador <--------------------------------------------------------------------------------
       
    }
    
    void registrarMovimiento(Object elementoJuego){
        System.out.println("Movimiento registrado xD ");
        //Aqui le hablaremos a la fachade de partida para registrar el movimiento <----------------------------------------------------------------------------
    }

    @Override
    public void crearPartida(IJugador jugador) throws IOException {
        Recceiver r = new Recceiver(jugador.getPuerto()); // Creamos el hilo para que este pendiente de los demas jugadores
        r.esperarPaquete();
        partida.crearPartida(jugador);
        partida.setDueno(jugador);
        System.out.println("Le hablo a iniciar peticiones");
    }
    
    void rechazarPeticion(IJugador jugador) throws IOException{
        paquete.clear();
        paquete.add("Rechazar");
        paquete.add(jugador);
        
        enviarPaquete(jugador.getIp(), jugador.getPuerto(), paquete);
        
    }
    
    void mostrarPeticionRechazada(){
        System.out.println("Se rechazo la peticion");
        //Aqui le hablaremos al peer para que le muestre al jugador que se ha rechazado la petcion <-----------------------------------------------------------
    }

    @Override
    public void iniciarPartida(IJugador jugador) {
        System.out.println("Si encotro a iniciar partida en la real comunication");
        paquete.clear();
        paquete.add("JugadorListo");
        paquete.add(jugador);
        
        IFacadePartida p = (IFacadePartida) ConcreateCreatorNegocio.factoryMethod("partida");
        jugadores = p.enviarJugadores(); // Se los esta trayendo de la partida xD tenemos que cambia rel nombre
        
        for(int i = 0; i < jugadores.size(); i++){
            
            try {
                enviarPaquete(jugadores.get(i).getIp(),jugadores.get(i).getPuerto(), paquete);
            } catch (IOException ex) {
                Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void anotarJugadorListo(IJugador jugador){
        System.out.println("Entro a anotar jugador como liSi essto");
        System.out.println("Este es el guey: " + jugadores.get(0).getNombre());
        
        int aux = 0;
        
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.get(i).getPuerto() == jugador.getPuerto()){
                aux = i;
                break;
            }
        }
        
        jugadores.get(aux).setEstado(true);
        //Aqui deberia de hacer un recorrido para saber si todos los jugadores
        //ya estan listos para inicar para setear a la partida que ya pueda
        //comenzar a recibir movimientos de los demas jugadores
        //ademas de que no se podran acepetar nuevos jugadores en esta partida
        boolean iniciar = true;
        
        
        
        for(int i=0; i<jugadores.size(); i++){
            if(!jugadores.get(i).isEstado()){
                iniciar = false;
            }
        }
        
        if(jugadores.size() == 1){
            iniciar = false;
        }
        
        if(iniciar){
            System.out.println("Se inicio la partida!!!!!!");
            partida.setPartidaIniciada(true);
            FrmSalaEspera frm = FrmSalaEspera.obtenerInstancia(null);
            System.out.println("Entro a setear jugador como listo!!!");
            frm.iniciarLaPartida();
        }
        
        FrmSalaEspera frm = FrmSalaEspera.obtenerInstancia(null);
        System.out.println("Entro a setear jugador como listo!!!");
        frm.setJugadorListo(jugador);
        
        
    }

    @Override
    public void iniciarSerividor(IJugador jugador) {
//        try {
//            servidor = new Recceiver(jugador.getPuerto());
//        } catch (IOException ex) {
//            Logger.getLogger(RealComunicacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        servidor.esperarPaquete();
//        System.out.println("Comenzo a esperar el paquete");
    }
    
}
