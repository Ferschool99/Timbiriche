/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

/**
 *
 * @author fer_p
 */
public class Tablero implements ElementoJuego{
    
    private ElementoJuego lineas[][];//Lineas horizontales
    private ElementoJuego cuadros[][];//cuadros creados

    private int sizeX;
    private int sizeY;
    
    private static Tablero instance;
    
    /**
     * El Constructor privado que permite instanciar la clase Tablero 
     * con su tamaño en x y y, es privado para respetar el patron de 
     * diseño singleton
     * @param x El tamaño en x
     * @param y El tamaño en Y
     */
    public Tablero(int x, int y){
        lineas = new Linea[(x*2)+1][y+1];
        for (int i = 0; i < (x*2)+1; i++) {
            for (int j = 0; j < y+1; j++) {
                lineas[i][j] = new Linea();
            }
        }
        
        cuadros = new Cuadro[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cuadros[i][j] = new Cuadro();
            }
        }
        
        this.sizeX = x;
        this.sizeY = y;
    }
    
    /**
     * Metodo que permite obtener la instancia de la clase TAblero
     * Respetando el patron Singleton
     * @param x El tamaño del tablero en X
     * @param y El tamaño del tablero en Y
     * @return 
     */
    public static Tablero obtenerInstancia(int x, int y){
        if(instance == null){
            instance = new Tablero(x, y);
        }
        return instance;
    }

    /**
     * Metodo que permite modificar el tamaño en X del tablero
     * @return El tamaño en X
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Metodo que permite obtener el tamaño en Y del tablero
     * @return El tamaño en Y del tablero
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * Agrega el dueño de una linea a el elemnto del juego, jugado por 
     * un jugador
     * @param owner El dueño de esta linea
     * @param x Lo posicision en x de la linea
     * @param y La posicion en y de la linea
     */
    public void addOwnerLinea(Jugador owner, int x, int y){
        lineas[x][y].addOwner(owner);
    }
    
    /**
     * Metodo que retorna una matriz con los cuadros dentro del tablero
     * @return 
     */
    @Override
    public ElementoJuego[][] obtenerCuadros(){
        return cuadros;
    }
    
    /**
     * Metodo que retorna una matriz de las lineas contenidas del tablero
     * @return 
     */
    @Override
    public ElementoJuego[][] obtenerLineas(){
        return lineas;
    }
    
    /**
     * Aqui es donde esta el algoritmo que se encarga de buscar todos los puntos
     * realizados en una jugada por un jugador
     * @param owner 
     */
    public void buscarPuntos(Jugador owner){
        int contx = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(lineas[contx][j].getOwner()!=null &&
                    lineas[contx+1][j+1].getOwner()!=null &&
                    lineas[contx+1][j].getOwner()!=null &&
                    lineas[contx+2][j].getOwner()!=null){
                    
                    cuadros[j][i].addOwner(owner);
                }
            }
            contx++;
            contx++;
        }
    }

    @Override
    public void addOwner(Jugador owner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jugador getOwner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

}
