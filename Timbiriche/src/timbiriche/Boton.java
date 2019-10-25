package timbiriche;

import javax.swing.JButton;


public class Boton extends JButton{
    
    public Boton(){}
    
    public Boton(boolean square){
        this.square=square;
    }
    //TAKEN ME DICE SI ESTE BOTON PARTICULAR YA FUÉ USADO
    private boolean taken=false;
    //SQUARE ME DIRÁ SI EL BOTON ES UN CUADRO(TRUE) O NO(FALSE)
    private boolean square=false;
    //OWNER GUARDA EL NOMBRE DEL JUGADOR QUE CERRÓ EL CUADRO, EN CASO DE SERLO
    private String owner;
    
    public boolean getTaken(){
        return taken;
    }
    public void setTaken(boolean taken){
        this.taken=taken;
    }
    
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner=owner;
        try{
            //EL CUADRO MOSTRARÁ EL PRIMER CARACTER DEL NOMBRE DEL DUEÑO
            this.setText(owner);
        }
        catch(Exception e){
            this.setText(null);
        }
    }
    
    public boolean getSquare(){
        return square;
    }
    public void setSquare(boolean square){
        this.square=square;
    }
}
