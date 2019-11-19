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
public class Empleado extends Thread{
    Cinta cinta;
    //Avion avion;
    String id_empleado;

    public Empleado(Cinta cinta, /*Avion avion,*/ String id_empleado) {
        this.cinta = cinta;
        //this.avion = avion;
        this.id_empleado = id_empleado;
    }
    public void run(){
        for(int i=1; i<81; i++){
            Maleta m;
            try {
                sleep(400 + (int) (700 * Math.random())); //Transporta maleta
                m=cinta.extraer(); //Empleado coge maleta     
                System.out.println(id_empleado + " Coge: " + m.getId_maleta());
                //sleep(400 + (int) (700 * Math.random())); //Vuelve a la cinta
                //avion.insertar(m);
                
            } catch (InterruptedException e) {
            }
        }
        
    }
}
