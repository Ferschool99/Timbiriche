/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fer_p
 */
public class Forwarder
{
    
    private int puerto = 1234; //Puerto para la conexión
    private String ip = "localhost"; //Host para la conexión
    private String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    private ServerSocket ss; //Socket del servidor
    private Socket cs; //Socket del cliente
    private DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
    
    public Forwarder(String ip, int puerto) throws IOException{
        this.ip = ip;
        this.puerto = puerto;
        cs = new Socket(ip, puerto);
    } //Se usa el constructor para remitente de Conexion

    public void enviarMsg(String msg) //Método para iniciar el Remitente
    {
        try
        {
            //Flujo de datos hacia el Recibidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            
            salidaServidor.writeUTF(msg);

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}