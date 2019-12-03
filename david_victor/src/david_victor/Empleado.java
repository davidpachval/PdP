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
public class Empleado extends Thread{
    Cinta cinta;
    Avion avion;
    String id_empleado;
    JTextField em;
    StartStop paso;
    StartStop todo;

    public Empleado(Cinta cinta, Avion avion, String id_empleado, JTextField empleado, StartStop paso, StartStop todo) {
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
                //System.out.println("-------------->>>"+id_empleado + " Coge: " + m.getId_maleta());
                sleep(400 + (int) (700 * Math.random())); //Vuelve a la cinta
                avion.insertar(m); //Empleado inserta maleta en el avión1
                todo.mirar();
                paso.mirar();
                imprimir(0, m);
                //System.out.println("------------------------------------->>>"+ id_empleado + " deja: "+ m.getId_maleta());
                
            } catch (InterruptedException e) {
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
