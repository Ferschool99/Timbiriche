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
public class Receiver {
    
    private Socket socket;
    private ObjectInputStream clienteRecibe;
    private ObjectOutputStream clientSalida;
    
    public Object escucharAlServidor() throws IOException, ClassNotFoundException{
        while(true){
            Object objetoRecibido = obtenerRespuesta();
            if(objetoRecibido != null){
                return objetoRecibido;
            }else{
                return null;
            }
        }
    }
    
    private Object obtenerRespuesta() throws IOException, ClassNotFoundException {
        return clienteRecibe.readObject();
    }
    
}
