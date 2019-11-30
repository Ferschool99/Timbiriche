/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Fernando
 */
public class ConcreateCreator {

    public static Object factoryMethod(String str) {
        
        if("Partida".equalsIgnoreCase(str)){
            return Partida.getPartida();
        }
        if("Jugador".equalsIgnoreCase(str)){
            return new Jugador();
        }
        if("ColorJugador".equalsIgnoreCase(str)){
            return new ColorJugador();
        }
        return null;
    }

    
}
