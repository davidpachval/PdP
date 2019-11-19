/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

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
    
    public Cinta(int max) {
        this.maximo = max;
        cinta = new ArrayList(max);
        lleno = new Semaphore(max);
    }
    
    public void insertar(Maleta m) throws InterruptedException {
        lleno.acquire();
        control.acquire();
        cinta.add(m);
        control.release();
        vacio.release();
    }
    public Maleta extraer() throws InterruptedException {
        Maleta m;
        vacio.acquire();
        control.acquire();
        m=cinta.remove(0);
        control.release();
        lleno.release();
        return m;
    }
}
