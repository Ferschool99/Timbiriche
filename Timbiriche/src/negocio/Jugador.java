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
class Jugador implements IJugador, Serializable{
    
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
    
    Jugador(String nombre, int puerto, String ip, Icon avatar)
    {
        this.nombre = nombre;
        this.puerto = puerto;
        this.ip = ip;
        this.avatar = avatar;
    }
    
    @Override
    public void sumaPuntos(int puntos)
    {
        this.puntos+=puntos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public int getPuerto() {
        return puerto;
    }

    @Override
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }

    @Override
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public Icon getAvatar() {
        return avatar;
    }

    @Override
    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }
    
}
