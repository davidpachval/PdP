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
public class Empleado extends Thread{
    Cinta cinta;
    Avion avion;
    String id_empleado;
    JTextField em;
    StartStop paso;
    StartStop todo;
    String texto = "";

    public Empleado(Cinta cinta, Avion avion, String id_empleado, JTextField empleado, StartStop paso, StartStop todo, long t0) {
        this.cinta = cinta;
        this.avion = avion;
        this.id_empleado = id_empleado;
        this.em = empleado;
        this.paso = paso;
        this.todo = todo;

    }
    public void run(){
        for(int i=1; i<81; i++){
            Maleta m = null;
            try {
                
                
                sleep(400 + (int) (700 * Math.random())); //Transporta maleta
                m=cinta.extraer(); //Empleado coge maleta 
                
                todo.mirar();
                paso.mirar();
                imprimir(1, m);
                texto = (id_empleado + " Coge: " + m.getId_maleta());
                GuardarDatos.ModificarLog(texto);

                //System.out.println("-------------->>>"+id_empleado + " Coge: " + m.getId_maleta());
                sleep(400 + (int) (700 * Math.random())); //Vuelve a la cinta
                avion.insertar(m); //Empleado inserta maleta en el avión1
                todo.mirar();
                paso.mirar();
                imprimir(0, m);
                texto = (id_empleado + " Deja en el avión: " + m.getId_maleta());
                GuardarDatos.ModificarLog(texto);
                //System.out.println("------------------------------------->>>"+ id_empleado + " deja: "+ m.getId_maleta());
                
            } catch (InterruptedException e) {
            } catch (IOException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void imprimir(int i, Maleta m){
        String c = "";
        if (i==0){
            c = "Volviendo del Avión";
        }else if(i==1){
            c = c + "llevando: "+ m.getId_maleta();
        }else{
            c=c + "No hay nada --> Descanso";
        }
        em.setText(c);
    }

}
