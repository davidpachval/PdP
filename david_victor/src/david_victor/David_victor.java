/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

/**
 *
 * @author David Pacheco Valero
 */
public class David_victor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cinta c = new Cinta(8);
        for(int i=1; i<21; i++){
            Thread p = new Pasajero(c, "Pasajero"+i);
            p.start();
        }
        
        
    }
    
}
