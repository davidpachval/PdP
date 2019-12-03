package david_victor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase Paso define un cerrojo con un Condition para la variable booleana cerrado
// que es comprobada por un proceso.
// Si vale false(abierto) el proceso puede continuar. Si es true(cerrado) el proceso se detiene
public class StartStop
{
    private boolean cerrado=false;
    private Lock cerrojo = new ReentrantLock();
    private Condition parar = cerrojo.newCondition();

    public void mirar()
    {
        try
        {
            cerrojo.lock();
            while(cerrado)
            {
                try
                {
                    parar.await();
                } catch(InterruptedException ie){ }
            }
        }
        finally
        {
            cerrojo.unlock();
        }
    }
    
    public void abrir()
    {
        try
        {
            cerrojo.lock();
            cerrado=false;
            parar.signalAll();
        }
        finally
        {
            cerrojo.unlock();
        }
    }
    
    public void cerrar()
    {
        try
        {
            cerrojo.lock();
            cerrado=true;
        }
        finally
        {
            cerrojo.unlock();
        }
    }
}
