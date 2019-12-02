/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author Fernando
 */
public class Jugador implements IJugador, Serializable{
    
    String nombre;
    String ip;
    
    boolean estado = false; //Este atributo nos dira si el jugador ya esta listo
    //para jugar en una partida en la que se encuentre unido.
    
    int puerto;
    int puntos;
    
    Icon avatar;
    
    public Jugador()
    {
        
    }

    @Override
    public boolean isEstado() {
        return estado;
    }

    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public Jugador(String nombre, int puerto, String ip, Icon avatar)
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

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
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
