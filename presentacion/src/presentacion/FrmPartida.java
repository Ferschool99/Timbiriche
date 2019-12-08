/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import negocio.ConcreateCreatorNegocio;
import negocio.IColorJugador;
import negocio.IFacadePartida;
import negocio.IJugador;

/**
 *
 * @author fer_p
 */
public class FrmPartida extends javax.swing.JFrame implements ActionListener {

    JButton botones[][];
    JPanel cuadros[][];
    IFacadePartida partida = (IFacadePartida) ConcreateCreatorNegocio.factoryMethod("Partida");
    IColorJugador colorTablero = (IColorJugador) ConcreateCreatorNegocio.factoryMethod("ColorJugador");
    
    ArrayList<IJugador> jugadores = partida.enviarJugadores();
    
        
    
    
    /**
     * Creates new form frmPartida
     */
    public FrmPartida() {
        initComponents();
        this.setResizable(false);
        
        lblJugador3.setVisible(false);
        lblJugador3Img.setVisible(false);
        lblJugador4.setVisible(false);
        lblJugador4Img.setVisible(false);
        
        
        int x = jugadores.size();
        int y = jugadores.size();
        partida.iniciarPartida();
        agregarLineas((x*10), (y*10));
        agregarCuadros((x*10), (y*10));
        int j= jugadores.size();
        System.out.println(j);
        lblJugador1.setText(jugadores.get(0).getNombre());
        lblJugador1Img.setText(null);
        lblJugador1Img.setIcon(jugadores.get(0).getAvatar());
        if(j==2)
        {
            lblJugador2.setText(jugadores.get(1).getNombre());
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
        }
        if(j==3)
        {
            lblJugador3.setVisible(true);
            lblJugador3Img.setVisible(true);
            lblJugador2.setText(jugadores.get(1).getNombre());
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
            lblJugador3.setText(jugadores.get(2).getNombre());
            lblJugador3Img.setText(null);
            lblJugador3Img.setIcon(jugadores.get(2).getAvatar());
        }
        if(j==4)
        {
            lblJugador3.setVisible(true);
            lblJugador3Img.setVisible(true);
            lblJugador4.setVisible(true);
            lblJugador4Img.setVisible(true);
            lblJugador2.setText(jugadores.get(1).getNombre());
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
            lblJugador3.setText(jugadores.get(2).getNombre());
            lblJugador3Img.setText(null);
            lblJugador3Img.setIcon(jugadores.get(2).getAvatar());
            lblJugador4.setText(jugadores.get(3).getNombre());
            lblJugador4Img.setText(null);
            lblJugador4Img.setIcon(jugadores.get(3).getAvatar());
        }
    }
    
    /**
     * Este metodo se encarga de pintar los cuadros segun los dueños dentro del
     * tablero, este seta llamado cada que un jugador haga un movimiento en su
     * propio tablero, de modo que la clase tablero debe de llegar aqui para
     * hacer los movimientos correspondientes
     */
    public void pintarCuadros(){
//        Partida p = Partida.obtenerInstancia();
//        ElementoJuego[][] cuadros = p.getTablero().obtenerCuadros();
//        for (int i = 0; i < p.getTablero().getSizeX(); i++) {
//            for (int j = 0; j < p.getTablero().getSizeY(); j++) {
//                if(cuadros[i][j].getOwner() != null){
//                    this.cuadros[i][j].setBackground(colorTablero.obtenerColor(cuadros[i][j].getOwner()));
//                
//                }
//            }
//        }
    }

//    public void pintarLineas(){
//        Partida p = Partida.obtenerInstancia();
//        ElementoJuego[][] lineas = p.getTablero().obtenerLineas();
//        for (int i = 0; i < (p.getTablero().getSizeX()*2)+1; i++) {
//            for (int j = 0; j < p.getTablero().getSizeY()+1; j++) {
//                if(lineas[i][j].getOwner() != null){
//                    //this.botones[i][j].set;
//                    this.botones[i][j].setBackground(colorTablero.obtenerColor(lineas[i][j].getOwner()));
//                    //this.botones[i][j].setEnabled(false);
//                }
//            }
//        }
//    }
    
    /**
     * Metodo que permite agregar los cuadros del tablero en el form
     * @param x El tamaño en x del tablero
     * @param y El tamaño en y del tablero
     */
    public void agregarCuadros(int x, int y){
//        Tablero t = Tablero.obtenerInstancia(10, 10);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonTerminarPartida = new javax.swing.JButton();
        lblJugador1Img = new javax.swing.JLabel();
        lblJugador2Img = new javax.swing.JLabel();
        lblJugador3Img = new javax.swing.JLabel();
        lblJugador4Img = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();

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

        botonTerminarPartida.setText("Terminar Partida");
        botonTerminarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarPartidaActionPerformed(evt);
            }
        });

        lblJugador1Img.setText("jLabel5");

        lblJugador2Img.setText("jLabel5");

        lblJugador3Img.setText("jLabel5");

        lblJugador4Img.setText("jLabel5");

        lblJugador1.setText("jLabel5");

        lblJugador2.setText("jLabel5");

        lblJugador3.setText("jLabel5");

        lblJugador4.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(botonTerminarPartida))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblJugador2Img)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblJugador1Img)))
                            .addComponent(lblJugador3Img)
                            .addComponent(lblJugador4Img))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugador1)
                            .addComponent(lblJugador2)
                            .addComponent(lblJugador4)
                            .addComponent(lblJugador3))))
                .addGap(87, 87, 87)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJugador1Img)
                        .addComponent(lblJugador1)))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador2Img)
                    .addComponent(lblJugador3))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador3Img)
                    .addComponent(lblJugador2))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador4Img)
                    .addComponent(lblJugador4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonTerminarPartida)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonTerminarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarPartidaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonTerminarPartidaActionPerformed

    
    //Aqui es donde estaremos interpretando todas las entradas de eventos de los botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Entro al ap");
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 11; j++) {
                if(ae.getSource() == botones[i][j] && partida.tienesDueno(i,j)==true){
                    //botones[i][j].setBackground(Color.black);
                    
                    if(partida.realizarMovimiento(partida.getDueno(), i, j)){ //va y le pregunta a partida si es su turno
                        //los estoy cambiando dinamicamente para pruebas y solo tener dos xd
                        System.out.println("Se asigno linea");
                        this.botones[i][j].setBackground(colorTablero.obtenerColor((IJugador) partida.getDueno()));
                        if(partida.buscarPuntos(partida.getDueno()))
                            this.cuadros[j][i].setBackground(colorTablero.obtenerColor(partida.getDueno()));
                        
                    }
//                    
//                    pintarLineas();
//                    pintarCuadros();
                    System.out.println("Se ejecuto movimiento " + i + " y "+ j );
                    
                    
//                if(ae.getSource() == botones[i][j] && partida.getTablero().obtenerLineas()[i][j].getOwner()==null){
//                    Tablero t = Tablero.obtenerInstancia(10, 10);
//                    //botones[i][j].setBackground(Color.black);
//                    
//                    if(partida.ejecutarTurno(partida.obtenerJugadores()[0],i,j)){ //va y le pregunta a partida si es su turno
//                        //los estoy cambiando dinamicamente para pruebas y solo tener dos xd
//                    }else{
//                       partida.ejecutarTurno(partida.obtenerJugadores()[1],i,j);
//                    }
//                    
//                    pintarLineas();
//                    pintarCuadros();
//                    
                }else{
                        System.out.println("Linea ocupada");
                    }
            }
        }
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonTerminarPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador1Img;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador2Img;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador3Img;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JLabel lblJugador4Img;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
