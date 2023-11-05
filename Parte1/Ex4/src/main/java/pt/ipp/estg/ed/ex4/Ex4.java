

package pt.ipp.estg.ed.ex4;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;

/**
 *
 * @author Sandro Cunha
 */
public class Ex4 {

    public static void main(String[] args) throws QueueEmptyException, DifferentArraysSizeException {
        
        MessageCodificator mc = new MessageCodificator("[g}i%Ihujunume", new int[]{1,2,3,4,5,6,7,8,9,3,5,7,5,4});
        
       
        System.out.println(mc.MessageDecodifier());
    }
}
