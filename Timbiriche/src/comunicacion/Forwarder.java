/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Mauriciowi100
 */
public class Forwarder {
    
    private Socket socket;
    private ObjectInputStream clienteRecibe;
    private ObjectOutputStream clientSalida;
    
    public void sendJugador(Object jugador, int puerto, String ip) throws IOException
    {
        socket = new Socket(ip, puerto);
        clienteRecibe = new ObjectInputStream(socket.getInputStream());
        clientSalida = new ObjectOutputStream(socket.getOutputStream());
        clientSalida.writeObject(jugador);
        clientSalida.flush();
    }
    
    
    
}
