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
class Tablero {
    
    private int sizeX;
    private int sizeY;

    private ElementoJuego lineas[][];//Lineas horizontales
    private ElementoJuego cuadros[][];//cuadros creados
    
    Tablero(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        lineas = (ElementoJuego[][]) new Linea[(sizeX*2)+1][sizeY+1];
        cuadros = (ElementoJuego[][]) new Cuadro[sizeX][sizeY];
    }
    
    void crearLinea(ElementoJuego elementoJuego){
        if(lineas[elementoJuego.getPositionX()][elementoJuego.getPositionY()] != null){
            lineas[elementoJuego.getPositionX()][elementoJuego.getPositionY()].setJugador(elementoJuego.getOwner());
        }
    }
    
}
