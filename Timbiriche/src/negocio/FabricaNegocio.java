/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Mauriciowi100
 */
public class FabricaNegocio {
    public static IFacadePartida getFachada()
    {
        return Partida.getPartida();
    }
}
