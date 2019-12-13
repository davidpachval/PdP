/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Victor
 */
public class GuardarDatos {
    
    private long t0;

    public GuardarDatos(long t0) {
        this.t0 = t0;
    }
    
    public static void CrearLog() throws IOException {

        try {

//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            FileWriter archivo = new FileWriter(new File("texto.txt"), false);
            archivo.close();

//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
//Escribimos en el archivo con el metodo write
            

//Cerramos la conexion


        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
    public static void ModificarLog(String texto) throws IOException {
        Calendar calendario = Calendar.getInstance(Locale.FRANCE);
        try {
            FileWriter archivo = new FileWriter(new File("texto.txt"), true);
            archivo.write(calendario.getTimeInMillis()+texto);
            archivo.append("\r\n");
            archivo.close();
            
        } catch (Exception e){
            
        }
        
    }

}
