
package Exceptions;

/**
 *Excepção de tamanhos diferentes num array
 * @author Sandro Cunha 8200785
 */
public class DifferentArraysSizeException extends Exception{
    
    public DifferentArraysSizeException() {
        
        super("Arrays Sizes don't match.");
    
    }
}