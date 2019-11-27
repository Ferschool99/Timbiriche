/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;

/**
 *
 * @author Mauriciowi100
 */
public class Juas {

        private static Socket socket;
        private static ObjectInputStream clienteRecibe;
        private static ObjectOutputStream clientSalida;
        private static Jugador juga;
        
        private static Object obtenerRespuesta() throws IOException, ClassNotFoundException {
        return clienteRecibe.readObject();
    }
        
        public void run() throws ClassNotFoundException {
        try {
            ServerSocket servidor = new ServerSocket(9999);
            while (true) {
                juga = (Jugador) clienteRecibe.readObject();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        socket = new Socket("localhost", 9999);
        clienteRecibe = new ObjectInputStream(socket.getInputStream());
        clientSalida = new ObjectOutputStream(socket.getOutputStream());
        clientSalida.writeObject(new Jugador("Mau", "18254", "48", new ImageIcon("E:\\Mauriciowi100\\Documents\\GitHub\\Timbiriche\\Timbiriche\\imagen2.jpg")));
        clientSalida.flush();
        Jugador jugador;        
        while(true){
            jugador = (Jugador) obtenerRespuesta();
        }
        
        
        /*Jugador jugador = new Jugador("mauricio", "80", "198.0.12.15", new ImageIcon("E:\\Mauriciowi100\\Documents\\GitHub\\Timbiriche\\Timbiriche\\imagen2.jpg"));
        Forwarder enviar = new Forwarder();
        enviar.sendJugador(jugador, 4000, "localhost");
        
        Receiver recibir = new Receiver();
        Jugador jugador2 = (Jugador) recibir.escucharAlServidor();*/
    }
    
}
