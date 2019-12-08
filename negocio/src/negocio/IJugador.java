/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.swing.Icon;

/**
 *
 * @author Fernando
 */
public interface IJugador {
    
    public void sumaPuntos(int puntos);

    public String getNombre();

    public void setNombre(String nombre);

    public String getIp();

    public void setIp(String ip);

    public int getPuerto();

    public void setPuerto(int puerto);

    public int getPuntos();

    public void setPuntos(int puntos);

    public Icon getAvatar();

    public void setAvatar(Icon avatar);
    
    public boolean isEstado();
    
    public void setEstado(boolean estado);
}
