/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

/**
 *
 * @author Fernando
 */
public class ConcreateCreator implements Creator{

    @Override
    public Object FactoryMethod(String str) {
        if("Proxy".equalsIgnoreCase(str)){
            return new Proxy();
        }
        return null;
    }
    
}
