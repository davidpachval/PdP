/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author David Pacheco Valero
 */

public class Pasajero extends Thread {

    Cinta cinta;
    String id_pasajero;
    StartStop todo;
    String texto = "";

    public Pasajero(Cinta cinta, String id_pasajero, StartStop todo, long t0) {
        this.cinta = cinta;
        this.id_pasajero = id_pasajero;
        this.todo = todo;
    }

    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            Maleta m = new Maleta(id_pasajero + "-M-" + i);
            try {
                sleep(500 + (int) (1000 * Math.random()));
                todo.mirar();
                cinta.insertar(m); //Pasajero inserta la maleta en la cinta
                texto = id_pasajero+"Deja: " +m.getId_maleta();
                GuardarDatos.ModificarLog(texto);
                //System.out.println(id_pasajero + " deja: "+m.getId_maleta());

            } catch (InterruptedException e) {
            } catch (IOException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }                

        }

    }

    

}
