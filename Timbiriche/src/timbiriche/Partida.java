/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

/**
 *  En esta clase se definen quien de quien es el turno 
 * al igual que se encargara de estar resiviendo las jugadas efectudas
 * segun el turno de cada jugador es donde se en contrara la comunicacion 
 * real del servidor con sus clientes con los Sockets 
 * @author fer_p
 */
public class Partida {
    
    private Jugador[] jugadores = new Jugador[4];
    private Tablero tablero;
    
    private int numJugadores = 0;
    
    public static Partida instance;
    
    /**
     * Metodo que se encarga de inicializar la clase partida
     * @param x El tamaño del tablero creado para la partida
     * @param y El tamaño del tablero creado para la partida
     */
    private Partida(){
        crearTablero(10,10); //Como aun no esta el frmCrear partida para crear
                            //el tablero lo cree aqui para pruebas
    }
    
    public static Partida obtenerInstancia(){
        if(instance == null){
            instance = new Partida();
        }
        return instance;
    }
    
    public void crearTablero(int x, int y){
        tablero = new Tablero(x,y);
    }
    
    /**
     * Esta posiblemente sea la clase que este resiviendo entradas de los 
     * Sockets
     * @param jugador El nuevo jugador en la partida
     * @return 
     */
    public boolean agregarJugador(Jugador jugador){
        for(int i=0; i<4; i++){
            if(jugadores[i]==null){
                jugadores[i] = jugador;
                return true;
            }
        }
        numJugadores++;
        return false;
    }
    
    private boolean turno(Jugador jugador){
        int i = 0;
        if(i == numJugadores)i = 0;
        if(jugadores[i] == jugador){
            i++;
            return true;
        }
        return false;
    }

    public Jugador[] obtenerJugadores() {
        return jugadores;
    }
    
    
    
    public boolean ejecutarTurno(Jugador jugador, int i, int j){
        if(turno(jugador)){
            tablero.addOwnerLinea(jugador, i, j);
            tablero.buscarPuntos(jugador);
            return true;
        }
        return false;
    }

    public Tablero getTablero() {
        return tablero;
    }

}
