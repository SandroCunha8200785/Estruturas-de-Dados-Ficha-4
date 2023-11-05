
package Exceptions;

/**
 * Excepção de fila cheia
 * @author SandroCunha8200785
 */
public class QueueFullException extends Exception{
    public QueueFullException() {
        
        super("The Queue is full.");
    
    }
}
