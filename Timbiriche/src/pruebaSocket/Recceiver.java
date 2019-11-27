/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fer_p
 */
public class Recceiver extends Thread  //Se hereda de conexión para hacer uso de los sockets y demás
{
    
    private String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    private ServerSocket ss; //Socket del servidor
    private Socket cs; //Socket del cliente
    private ObjectInputStream salidaCliente; //Flujo de datos de salida
    private String msgRecibido="";
    
    public Recceiver(int puerto) throws IOException{
        puerto = puerto;
        ss = new ServerSocket(puerto);//Se crea el socket para el servidor en puerto 1234
        cs = new Socket(); //Socket para el cliente
        start();
    } 

    @Override
    public void run()//Método para iniciar el servidor
    {
        try
        {
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            System.out.println(".::Remitente en línea::.");
            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new ObjectInputStream(cs.getInputStream());
            //Se le envía un mensaje al cliente usando su flujo de salida
            //Se obtiene el flujo entrante desde el cliente
            Jugador jugador = (Jugador) salidaCliente.readObject();

                //Se muestra por pantalla el mensaje recibido
                msgRecibido = jugador.getNombre();
                Peer per = Peer.obtenerInstancia();
                per.recibirMensage(msgRecibido);
                System.out.println("Mensaje:  "+msgRecibido);
            
            
            ss.close();//Se finaliza la conexión con el cliente
        
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
