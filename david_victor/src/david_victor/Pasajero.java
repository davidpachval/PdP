/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import javax.swing.JTextField;

/**
 *
 * @author David Pacheco Valero
 */

public class Pasajero extends Thread {

    Cinta cinta;
    String id_pasajero;
    StartStop todo;


    public Pasajero(Cinta cinta, String id_pasajero, StartStop todo) {
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
                //System.out.println(id_pasajero + " deja: "+m.getId_maleta());

            } catch (InterruptedException e) {
            }                

        }

    }

    

}
