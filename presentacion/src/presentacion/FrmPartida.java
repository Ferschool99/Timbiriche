/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import comunicacion.ConcreateCreatorComunicacion;
import comunicacion.IComunicacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    ConcreateCreatorComunicacion fabrica = new ConcreateCreatorComunicacion();
    IComunicacion proxy = (IComunicacion) fabrica.FactoryMethod("Proxy");
    public static FrmPartida instance;
    IJugador turno;
    
    ArrayList<IJugador> jugadores = partida.enviarJugadores();
    
        
    
    
    /**
     * Creates new form frmPartida
     */
    private FrmPartida() {
        initComponents();
        this.setResizable(false);
        
        lblJugador3.setVisible(false);
        lblJugador3Img.setVisible(false);
        lblJugador4.setVisible(false);
        lblJugador4Img.setVisible(false);
        btnColor3.setVisible(false);
        btnColor4.setVisible(false);
        this.setResizable(true); //<-------------------------- ELIMINAR ESTA LINEA
        int x = jugadores.size() - 1;
        int y = jugadores.size() - 1;
        x = x*10;
        y = y*10;
        partida.iniciarPartida();
        agregarLineas(x, y);
        agregarCuadros(x, y);
        int j= jugadores.size();
        System.out.println(j);
        lblJugador1.setText("0");
        lblJugador1Img.setText(null);
        lblJugador1Img.setIcon(jugadores.get(0).getAvatar());
        btnColor1.setBackground(colorTablero.obtenerColor(jugadores.get(0)));
        if(j==2)
        {
            lblJugador2.setText("0");
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
            btnColor2.setBackground(colorTablero.obtenerColor(jugadores.get(1)));
            
            lblJugador1Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador2Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
        if(j==3)
        {
            lblJugador2.setVisible(true);
            lblJugador3.setVisible(true);
            lblJugador3Img.setVisible(true);
            lblJugador3.setText("0");
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
            lblJugador2.setText("0");
            lblJugador3Img.setText(null);
            lblJugador3Img.setIcon(jugadores.get(2).getAvatar());
            btnColor2.setBackground(colorTablero.obtenerColor(jugadores.get(1)));
            btnColor3.setBackground(colorTablero.obtenerColor(jugadores.get(2)));
            btnColor3.setVisible(true);
            
            lblJugador1Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador2Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador3Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
        if(j==4)
        {
            
            lblJugador1Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador2Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador3Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador4Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
            lblJugador2.setVisible(true);
            lblJugador3.setVisible(true);
            lblJugador3Img.setVisible(true);
            lblJugador4.setVisible(true);
            lblJugador4Img.setVisible(true);
            lblJugador3.setText("0");
            lblJugador2Img.setText(null);
            lblJugador2Img.setIcon(jugadores.get(1).getAvatar());
            lblJugador2.setText("0");
            lblJugador3Img.setText(null);
            lblJugador3Img.setIcon(jugadores.get(2).getAvatar());
            lblJugador4.setText("0");
            lblJugador4Img.setText(null);
            lblJugador4Img.setIcon(jugadores.get(3).getAvatar());
            btnColor2.setBackground(colorTablero.obtenerColor(jugadores.get(1)));
            btnColor3.setBackground(colorTablero.obtenerColor(jugadores.get(2)));
            btnColor4.setBackground(colorTablero.obtenerColor(jugadores.get(3)));
            btnColor4.setVisible(true);
        }
        
    }
    
    public static FrmPartida obtenerInstancia(){
        
        if(instance == null){
            instance = new FrmPartida();
        }
        
        return instance;
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
        for(int i=0; i<(x * 2)+1; i++){
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
    
    
    private void cambiarColores(Color newColor, Color oldColor){
        int x = jugadores.size() - 1;
        int y = jugadores.size() - 1;
        x = x*10;
        y = y*10;
        if(newColor==null)
        {
            //Cambia el color de las lineas
            for(int i=0; i<(x*2)+1; i++){
                if(i == 0){
                    int posicion = 0;
                    for (int j = 0; j < y; j++) {
                        if(botones[i][j].getBackground().equals(oldColor)){
                            botones[i][j].setBackground(new JButton().getBackground());
                        }
                    }
                }else{
                    if(i % 2 != 0){
                        for (int j = 0; j < y+1; j++) {
                            if(botones[i][j].getBackground().equals(oldColor)){
                                botones[i][j].setBackground(new JButton().getBackground());
                            }
                        }
                    }else{
                        for (int j = 0; j < y; j++) {
                            if(botones[i][j].getBackground().equals(oldColor)){
                                botones[i][j].setBackground(new JButton().getBackground());
                            }
                        }
                    }
                }
            }


            //Cambia los colores de cuadros
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if(cuadros[i][j].getBackground().equals(oldColor)){
                        cuadros[i][j].setBackground(new JButton().getBackground());
                    }
                }
            }
        }
        else
        {
            //Cambia el color de las lineas
            for(int i=0; i<(x*2)+1; i++){
                if(i == 0){
                    int posicion = 0;
                    for (int j = 0; j < y; j++) {
                        if(botones[i][j].getBackground().equals(oldColor)){
                            botones[i][j].setBackground(newColor);
                        }
                    }
                }else{
                    if(i % 2 != 0){
                        for (int j = 0; j < y+1; j++) {
                            if(botones[i][j].getBackground().equals(oldColor)){
                                botones[i][j].setBackground(newColor);
                            }
                        }
                    }else{
                        for (int j = 0; j < y; j++) {
                            if(botones[i][j].getBackground().equals(oldColor)){
                                botones[i][j].setBackground(newColor);
                            }
                        }
                    }
                }
            }


            //Cambia los colores de cuadros
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if(cuadros[i][j].getBackground().equals(oldColor)){
                        cuadros[i][j].setBackground(newColor);
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
        lblJugador3 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();
        btnColor1 = new javax.swing.JButton();
        btnColor2 = new javax.swing.JButton();
        btnColor3 = new javax.swing.JButton();
        btnColor4 = new javax.swing.JButton();

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botonTerminarPartida.setText("Terminar Partida");
        botonTerminarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarPartidaActionPerformed(evt);
            }
        });

        lblJugador1Img.setText("jLabel5");
        lblJugador1Img.setMaximumSize(new java.awt.Dimension(100, 100));
        lblJugador1Img.setMinimumSize(new java.awt.Dimension(100, 100));
        lblJugador1Img.setPreferredSize(new java.awt.Dimension(100, 100));

        lblJugador2Img.setText("jLabel5");
        lblJugador2Img.setPreferredSize(new java.awt.Dimension(100, 100));

        lblJugador3Img.setText("jLabel5");
        lblJugador3Img.setPreferredSize(new java.awt.Dimension(100, 100));

        lblJugador4Img.setText("jLabel5");
        lblJugador4Img.setPreferredSize(new java.awt.Dimension(100, 100));

        lblJugador1.setText("jLabel5");

        lblJugador3.setText("jLabel5");

        lblJugador2.setText("jLabel5");

        lblJugador4.setText("jLabel5");

        btnColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor1ActionPerformed(evt);
            }
        });

        btnColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor2ActionPerformed(evt);
            }
        });

        btnColor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor3ActionPerformed(evt);
            }
        });

        btnColor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor4ActionPerformed(evt);
            }
        });

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
                            .addComponent(lblJugador2Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblJugador1Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblJugador3Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJugador4Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador3)
                                .addGap(18, 18, 18)
                                .addComponent(btnColor3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador2)
                                .addGap(18, 18, 18)
                                .addComponent(btnColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador1)
                                .addGap(18, 18, 18)
                                .addComponent(btnColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador4)
                                .addGap(26, 26, 26)
                                .addComponent(btnColor4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(46, 46, 46)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblJugador1Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblJugador1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJugador2Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJugador2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(btnColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJugador3Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJugador3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btnColor3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJugador4Img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJugador4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnColor4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)))
                .addComponent(botonTerminarPartida)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void eliminarJugador(IJugador jugador)
    {
        
        System.out.println("LLego hasta el final del eliminar");
        System.out.println("buscas "+ jugador.getNombre());
        cambiarColores(null, colorTablero.obtenerColor(jugador));
        partida.eliminarJugador(jugador);
        
    }
    
    private void botonTerminarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarPartidaActionPerformed
        // TODO add your handling code here:
        cambiarColores(null, colorTablero.obtenerColor(partida.getDueno()));
//        partida.eliminarJugador(partida.getDueno());
        proxy.abandonarPartida(partida.getDueno());
        System.exit(0);
    }//GEN-LAST:event_botonTerminarPartidaActionPerformed

    private void btnColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor2ActionPerformed
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Elige color de Jugador 2", colorTablero.obtenerColor(jugadores.get(1)));
        if(color != null){
            Color oldColor = btnColor2.getBackground();
            if(colorTablero.asignarColor(jugadores.get(1), color)){
                colorTablero.asignarColor(jugadores.get(1), color);
                cambiarColores(color, oldColor);
                btnColor2.setBackground(color);
            }
        }
    }//GEN-LAST:event_btnColor2ActionPerformed

    private void btnColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor1ActionPerformed
        // TODO add your handling code here:
        
        Color color = JColorChooser.showDialog(this, "Elige color de Jugador 1", colorTablero.obtenerColor(jugadores.get(0)));
        if(color != null){
            Color oldColor = btnColor1.getBackground();
            if(colorTablero.asignarColor(jugadores.get(0), color)){
                colorTablero.asignarColor(jugadores.get(0), color);
                cambiarColores(color, oldColor);
                btnColor1.setBackground(color);
            }
        }
    }//GEN-LAST:event_btnColor1ActionPerformed

    private void btnColor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor3ActionPerformed
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Elige color de Jugador 3", colorTablero.obtenerColor(jugadores.get(2)));
        if(color != null){
            Color oldColor = btnColor3.getBackground();
            if(colorTablero.asignarColor(jugadores.get(2), color)){
                colorTablero.asignarColor(jugadores.get(2), color);
                cambiarColores(color, oldColor);
                btnColor3.setBackground(color);
            }
        }
    }//GEN-LAST:event_btnColor3ActionPerformed

    private void btnColor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor4ActionPerformed
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Elige color de Jugador 4", colorTablero.obtenerColor(jugadores.get(3)));
        if(color != null){
            Color oldColor = btnColor4.getBackground();
            if(colorTablero.asignarColor(jugadores.get(3), color)){
                colorTablero.asignarColor(jugadores.get(3), color);
                cambiarColores(color, oldColor);
                btnColor4.setBackground(color);
            }
        }
    }//GEN-LAST:event_btnColor4ActionPerformed

    public void pintarLinea(IJugador jugador, int z, int y)
    {
        if(partida.realizarMovimiento(jugador, z, y))
        {
                this.botones[z][y].setBackground(colorTablero.obtenerColor(jugador));
                System.out.println("Pinto linea receiver");
                System.out.println(colorTablero.obtenerColor(jugador));
                System.out.println(z);
                System.out.println(y);
                ArrayList x = partida.buscarPuntos(jugador);
                if(!x.isEmpty()){
                    System.out.println("entre a pintar cuadro");
                for (int k = 1; k < x.size()-1; k++) {
                    System.out.println("hola");
                    this.cuadros[(int)x.get(k)][(int)x.get(k+1)].setBackground(colorTablero.obtenerColor(jugador));
                    k++;
                    k++;
                    for (int i = 0; i <= jugadores.size()-1; i++) {
                        if(jugadores.get(i).equals(jugador)){
                            jugadores.get(i).sumaPuntos(1);
                        }
                    }
                }
                x.clear();
                setPuntos();
                }
                asignTurn();
        }
    }
    
    public void setPuntos()
    {
        int puntos=0;
        int gan=0;
        for (int i = 0; i <= jugadores.size()-1; i++) {
            puntos+=jugadores.get(i).getPuntos();
            if(jugadores.get(gan).getPuntos()<jugadores.get(i).getPuntos())
                gan=i;
        }
        if(puntos==5/*(jugadores.size() - 1)*10*/)
        {
           JOptionPane.showMessageDialog(this, "Partida completada \nGanador : "+jugadores.get(gan).getNombre()+"\nPuntos: "+jugadores.get(gan).getPuntos());
           System.exit(0);
            
        }
        lblJugador1.setText(String.valueOf(jugadores.get(0).getPuntos()));
        lblJugador2.setText(String.valueOf(jugadores.get(1).getPuntos()));
        if(jugadores.size()>=3)
        {
            lblJugador3.setText(String.valueOf(jugadores.get(2).getPuntos()));
        }
        if(jugadores.size()>=4)
        {
            lblJugador4.setText(String.valueOf(jugadores.get(3).getPuntos()));
        }
    }
    
    void asignTurn()
    {
        turno = partida.getTurno();
        int x = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.get(i).equals(turno)){
                x=i;
            }
        }
        
            lblJugador1Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador2Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador3Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            lblJugador4Img.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        if(x == 0)
        {
            lblJugador1Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
        if(x == 1)
        {
            lblJugador2Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
        if(x == 2)
        {
            lblJugador3Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
        if(x == 3)
        {
            lblJugador4Img.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        }
    }
    
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
                        ArrayList x = partida.buscarPuntos(partida.getDueno());
                        if(!x.isEmpty()){
                            System.out.println("entre a pintar cuadro");
                        for (int k = 1; k <= x.size()-1; k++) {
                            System.out.println("hola");
                            this.cuadros[(int)x.get(k)][(int)x.get(k+1)].setBackground(colorTablero.obtenerColor(partida.getDueno()));
                            k++;
                            k++;
                            for (int l = 0; l <= jugadores.size()-1; l++) {
                                if(jugadores.get(l).equals(partida.getDueno())){
                                    jugadores.get(l).sumaPuntos(1);
                                        }
                                    }
                        }
                        x.clear();
                        }
                        asignTurn();
                        proxy.realizarMovimiento(partida.getDueno(), i, j);
                        System.out.println("Se ejecuto movimiento " + i + " y "+ j );
                        setPuntos();
                        
                    }
                    else
                    {
                        
                        JOptionPane.showMessageDialog(this, "No es tu turno >:v");
                    }
//                    
//                    pintarLineas();
//                    pintarCuadros();
                    
                    
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
                                        }
            }
        }
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonTerminarPartida;
    private javax.swing.JButton btnColor1;
    private javax.swing.JButton btnColor2;
    private javax.swing.JButton btnColor3;
    private javax.swing.JButton btnColor4;
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
