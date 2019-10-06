/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mauriciowi100
 */
public class TableroPnl extends javax.swing.JPanel implements ActionListener{

    Tablero form;
    /**
     * Creates new form TableroPnl
     */
    public TableroPnl(Tablero x) {
        initComponents();
        form=x;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent ae) {
        int x=0, y=0;
        for(x=0;x<19;x++){
                for(y=0;y<19;y++){
                    if(ae.getSource()==form.getBoton(x, y)){
                        form.getBoton(x, y).setTaken(true);
                        form.getBoton(x, y).setBackground(Color.red);
                        form.getBoton(x, y).setEnabled(false);
                        break;
                    }
                }
        }
        
        check(form.getMatriz());
    }
    
    public Boton[][] getMatriz()
    {
        return matriz; 
   }
    
    public void acomodar(Boton[][] matriz, boolean add){
        for(int x=0;x<19;x++){
            for(int y=0;y<19;y++){
                if(add){
                    matriz[x][y]=new Boton();
                    matriz[x][y].addActionListener(tablero);
                }
                else{
                    matriz[x][y].setOwner(null);
                    matriz[x][y].setTaken(false);
                }
                if(x%2==0){
                    if(y%2==0){
                        matriz[x][y].setBounds(0+(55*(y/2)),0+(55*(x/2)),5,5);
                        matriz[x][y].setBorderPainted(false);
                        matriz[x][y].setBackground(Color.black);
                        matriz[x][y].setEnabled(false);
                    }
                    else{
                        matriz[x][y].setBounds(5+(55*(y/2)),0+(55*(x/2)),50,5);
                        matriz[x][y].setBorderPainted(false);
                        matriz[x][y].setBackground(Color.white);
                    }
                }
                else{
                    if(y%2==0){
                        matriz[x][y].setBounds(0+(55*(y/2)),5+(55*(x/2)),5,50);
                        matriz[x][y].setBorderPainted(false);
                        matriz[x][y].setBackground(Color.white);
                    }
                    else{
                        matriz[x][y].setBounds(5+(55*(y/2)),5+(55*(x/2)),50,50);
                        matriz[x][y].setSquare(true);
                        matriz[x][y].setBorderPainted(false);
                        matriz[x][y].setBackground(Color.white);
                        matriz[x][y].setEnabled(false);
                    }
                }
                tablero.add(matriz[x][y]);
            }
        }
    }
    
    public Boton getBoton(int x, int y) {
        return matriz[x][y];
    }
    public void check(Boton[][] matriz){
        String player="m";
        for(int x=0;x<19;x++){
            for(int y=0;y<19;y++){
                if(matriz[x][y].getSquare() && !matriz[x][y].getTaken()){
                    if(matriz[x-1][y].getTaken() && matriz[x+1][y].getTaken() 
                            && matriz[x][y-1].getTaken() 
                            && matriz[x][y+1].getTaken()){
                        matriz[x][y].setOwner(player);
                        matriz[x][y].setTaken(true);
                    }
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
