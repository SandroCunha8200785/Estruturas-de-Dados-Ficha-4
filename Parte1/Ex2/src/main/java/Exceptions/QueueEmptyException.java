
package Exceptions;

/**
 * Excepçao de fila vazia
 * @author SandroCunha8200785
 */
public class QueueEmptyException extends Exception {
    
    public QueueEmptyException() {
        
        super("The Queue is empty.");
    
    }
}
