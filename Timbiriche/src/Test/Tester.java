/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import negocio.ConcreateCreator;
import negocio.Creator;
import negocio.IFacadePartida;
import negocio.IJugador;

/**
 *
 * @author Fernando
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Creator creador = new ConcreateCreator();
        
        IJugador jugador = (IJugador) creador.factoryMethod("Jugador");
        
        IFacadePartida partida = (IFacadePartida) creador.factoryMethod("Partida");
        
        
        jugador.setNombre("Fernando");
        
        System.out.print("Si se guardo alv: :v : ");
        System.out.println(jugador.getNombre());
        
    }
    
}
