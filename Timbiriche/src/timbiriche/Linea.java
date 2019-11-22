/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import javax.swing.JButton;

/**
 *
 * @author fer_p
 */
public class Linea extends JButton implements ElementoJuego{
    
    private Jugador owner;

    @Override
    public void addOwner(Jugador owner) {
        this.owner = owner;
        this.setText("M");
    }

    @Override
    public Jugador getOwner() {
        return this.owner;
    }

    @Override
    public ElementoJuego[][] obtenerCuadros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ElementoJuego[][] obtenerLineas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
