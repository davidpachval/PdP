/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JTextArea;

/**
 *
 * @author David Pacheco Valero
 */
public class Avion {
    private ArrayList<Maleta> avion;
    private Semaphore control = new Semaphore(1);
    JTextArea contenido;
    private int i =0;
    
    public Avion(JTextArea contenido_avion) {
        avion = new ArrayList();
        this.contenido = contenido_avion;
    }

    public void insertar(Maleta m) throws InterruptedException {
        control.acquire();
        avion.add(m);
        imprimir();
        
        control.release();
    }
    public void imprimir(){
        String c = "";
        for (int i = 0; i<avion.size(); i++){
            c = c + avion.get(i).getId_maleta()+ "      ";
        }
        contenido.setText(c);
    }
}
