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
    
    boolean crearLinea(Jugador jugador, int x, int y){
        if(lineas[x][y] == null){
            lineas[x][y] = new Linea(jugador);
            System.out.println("SE ASIGNO JUGADOR A LINEA");
            return true;
        }
        return false;
    }
    
    ElementoJuego[][] obtenerLinea()
    {
        return lineas;
    }
    
    public boolean buscarPuntos(Jugador jugador){
        int contx = 0;
        boolean b = false;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(lineas[contx][j]!=null &&
                    lineas[contx+1][j+1]!=null &&
                    lineas[contx+1][j]!=null &&
                    lineas[contx+2][j]!=null){
                    System.out.println("Agrego Cuadro al: "+jugador.getNombre());
                    if(cuadros[j][i]==null){
                        System.out.println("se creo el cuadro");
                        cuadros[j][i] = new Cuadro(jugador);
                        cuadros[j][i].add(lineas[contx][j]);
                        cuadros[j][i].add(lineas[contx+1][j+1]);
                        cuadros[j][i].add(lineas[contx+1][j]);
                        cuadros[j][i].add(lineas[contx+2][j]);
                        b =  true;
                    }
                    
                }
            }
            contx++;
            contx++;
        }
        return b;
    }
}
