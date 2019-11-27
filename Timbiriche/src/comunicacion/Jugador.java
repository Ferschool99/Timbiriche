/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import javax.swing.Icon;

/**
 *
 * @author Fernando
 */
public class Jugador {
    
    String nombre;
    String ip;
    String puerto;
    int puntos;
    Icon avatar;
    
    public Jugador()
    {
        
    }
    
    public Jugador(String nombre, String puerto, String ip, Icon avatar)
    {
        this.nombre = nombre;
        this.puerto = puerto;
        this.ip = ip;
        this.avatar = avatar;
    }
    
    public void sumaPuntos(int puntos)
    {
        this.puntos+=puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }
    
}
