/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David Pacheco Valero
 */
public class Servidor extends Thread{
    Cinta cinta;
    Avion avion;

    public Servidor(Cinta cinta, Avion avion) {
        this.cinta = cinta;
        this.avion = avion;
    }
    
    public void run(){
    
        ServerSocket servidor;
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;
        String envio1, envio2;
        int num = 0;
        try
        {
            servidor = new ServerSocket(3000); // Creamos un ServerSocket en el puerto 5000
            System.out.println("Servidor Arrancado....");
            while (true)
            {
                envio1 = "";
                envio2="";
                conexion = servidor.accept();     // Esperamos una conexión
                num++;
                System.out.println("Conexión nº "+num+" desde: "+conexion.getInetAddress().getHostName());
                
                
                entrada = new DataInputStream(conexion.getInputStream());  // Abrimos los canales de E/S
                salida  = new DataOutputStream(conexion.getOutputStream());
                String mensaje = entrada.readUTF();    //Leemos el mensaje del cliente
                
                
                System.out.println("Conexión nº "+num+". Mensaje recibido: "+mensaje);
                for(int i = 0; i < cinta.getCinta().size(); i++){
                    envio1=envio1 + cinta.getCinta().get(i).getId_maleta();
                }
                salida.writeUTF(envio1);
                for(int i = 0; i < avion.getAvion().size(); i++){
                    envio2=envio2 + avion.getAvion().get(i).getId_maleta();
                }
                salida.writeUTF(envio2);  // Le respondemos
                
                conexion.close();                           // Y cerramos la conexión
            }
        } catch (IOException e) {}
    }
    
}

