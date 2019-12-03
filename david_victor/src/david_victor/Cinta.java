/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

/**
 *
 * @author David Pacheco Valero
 */
public class Cinta {
    private ArrayList<Maleta> cinta;
    private int maximo;
    private Semaphore vacio = new Semaphore (0);
    private Semaphore lleno;
    private Semaphore control = new Semaphore(1);
    JTextField contenido;

    
    public Cinta(int max, JTextField contenido_cinta) {
        this.maximo = max;
        cinta = new ArrayList(max);
        lleno = new Semaphore(max);
        this.contenido = contenido_cinta; 
    }

    public ArrayList<Maleta> getCinta() {
        return cinta;
    }

    public void setCinta(ArrayList<Maleta> cinta) {
        this.cinta = cinta;
   
    }
    
    
    public void insertar(Maleta m) throws InterruptedException {
        lleno.acquire();
        control.acquire();
        cinta.add(m);
        imprimir();
        control.release();
        vacio.release();
    }
    public Maleta extraer() throws InterruptedException {
        Maleta m;
        vacio.acquire();
        control.acquire();
        m=cinta.remove(0);
        imprimir();
        control.release();
        lleno.release();
        return m;
    }
    public void imprimir(){
        String c = "";
        for (int i = 0; i<cinta.size(); i++){
            c = c + cinta.get(i).getId_maleta()+ "        ";
        }
        contenido.setText(c);
    }
}
