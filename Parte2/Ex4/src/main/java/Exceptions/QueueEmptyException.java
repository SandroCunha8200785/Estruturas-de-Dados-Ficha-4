
package Exceptions;

/**
 * Excepção de Fila VAzia
 * @author SandroCunha8200785
 */
public class QueueEmptyException extends Exception {
    
    public QueueEmptyException() {
        
        super("The Queue is empty.");
    
    }
}
