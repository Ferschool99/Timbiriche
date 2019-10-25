/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author fer_p
 */
public class frmPartida extends javax.swing.JFrame implements ActionListener {

    JButton botones[][];
    JPanel cuadros[][];
    Partida partida;
    ColorTablero colorTablero;
    
    Jugador jugador1 = new Jugador("Fernando");
    Jugador jugador2 = new Jugador("Bismarck");
    
    
    /**
     * Creates new form frmPartida
     */
    public frmPartida() {
        initComponents();
        this.setResizable(false);
        partida = Partida.obtenerInstancia();
        
        partida.agregarJugador(jugador1);//Los agregue para pruebas
        partida.agregarJugador(jugador2);//los agregue para pruebas
        
        colorTablero = new ColorTablero(partida.obtenerJugadores());
        agregarLineas(partida.getTablero().getSizeX(),partida.getTablero().getSizeY());
        agregarCuadros(partida.getTablero().getSizeX(),partida.getTablero().getSizeY());
    }
    
    /**
     * Este metodo se encarga de pintar los cuadros segun los dueños dentro del
     * tablero, este seta llamado cada que un jugador haga un movimiento en su
     * propio tablero, de modo que la clase tablero debe de llegar aqui para
     * hacer los movimientos correspondientes
     */
    public void pintarCuadros(){
        Partida p = Partida.obtenerInstancia();
        ElementoJuego[][] cuadros = p.getTablero().obtenerCuadros();
        for (int i = 0; i < p.getTablero().getSizeX(); i++) {
            for (int j = 0; j < p.getTablero().getSizeY(); j++) {
                if(cuadros[i][j].getOwner() != null){
                    this.cuadros[i][j].setBackground(colorTablero.obtenerColor(cuadros[i][j].getOwner()));
                }
            }
        }
    }

    public void pintarLineas(){
        Partida p = Partida.obtenerInstancia();
        ElementoJuego[][] lineas = p.getTablero().obtenerLineas();
        for (int i = 0; i < (p.getTablero().getSizeX()*2)+1; i++) {
            for (int j = 0; j < p.getTablero().getSizeY()+1; j++) {
                if(lineas[i][j].getOwner() != null){
                    this.botones[i][j].setBackground(colorTablero.obtenerColor(lineas[i][j].getOwner()));
                }
            }
        }
    }
    
    /**
     * Metodo que permite agregar los cuadros del tablero en el form
     * @param x El tamaño en x del tablero
     * @param y El tamaño en y del tablero
     */
    public void agregarCuadros(int x, int y){
        Tablero t = Tablero.obtenerInstancia(10, 10);
        cuadros = new JPanel[x][y];
        int posicionx = 0;
        int posiciony = 0;
        for (int i = 0; i < x; i++) {
            posiciony = 0;
            for (int j = 0; j < y; j++) {
                cuadros[i][j] = new JPanel();
                panelTablero.remove(cuadros[i][j]);
                cuadros[i][j].setBounds(posicionx+10, posiciony+10, 40, 40);
                cuadros[i][j].setVisible(true);
                cuadros[i][j].setBackground(Color.yellow);
                panelTablero.add(cuadros[i][j]);
                posiciony+=50;
            }
            posicionx += 50;
        }
    }
    
    /**
     * Metodo que permite agregar las lineas del talbero al form
     * @param x El tamaño en x del tablero
     * @param y El tamaño en y del tablero
     */
    private void agregarLineas(int x, int y){
        botones = new JButton[1000][1000];
        int posiciony = 0;
        for(int i=0; i<(x*2)+1; i++){
            if(i == 0){
                int posicion = 0;
                for (int j = 0; j < y; j++) {
                    botones[i][j]=new JButton();
                    botones[i][j].setBounds(posicion+5,posiciony,50,10);
                    botones[i][j].addActionListener(this);
                    botones[i][j].setVisible(true);
                    panelTablero.add(botones[i][j]);
                    posicion += 50;
                }
            }else{
                if(i % 2 != 0){
                    int posicion = 0;
                    for (int j = 0; j < y+1; j++) {
                        botones[i][j]=new JButton();
                        botones[i][j].setBounds(posicion,posiciony+5,10,50);
                        botones[i][j].addActionListener(this);
                        botones[i][j].setVisible(true);
                        panelTablero.add(botones[i][j]);
                        posicion += 50;
                    }
                    posiciony += 50;
                }else{
                    int posicion = 0;
                    for (int j = 0; j < y; j++) {
                        botones[i][j]=new JButton();
                        botones[i][j].setBounds(posicion+5,posiciony,50,10);
                        botones[i][j].addActionListener(this);
                        botones[i][j].setVisible(true);
                        panelTablero.add(botones[i][j]);
                        posicion += 50;
                    }
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 500));

        panelTablero.setBackground(new java.awt.Color(255, 255, 255));
        panelTablero.setPreferredSize(new java.awt.Dimension(510, 510));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPartida().setVisible(true);
            }
        });
    }

    
    //Aqui es donde estaremos interpretando todas las entradas de eventos de los botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 11; j++) {
                if(ae.getSource() == botones[i][j]){
                    Tablero t = Tablero.obtenerInstancia(10, 10);
                    //botones[i][j].setBackground(Color.black);
                    
                    if(partida.ejecutarTurno(jugador1,i,j)){ //va y le pregunta a partida si es su turno
                        //los estoy cambiando dinamicamente para pruebas y solo tener dos xd
                    }else{
                       partida.ejecutarTurno(jugador2, i, j);
                    }
                    
                    pintarLineas();
                    pintarCuadros();
                    
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
