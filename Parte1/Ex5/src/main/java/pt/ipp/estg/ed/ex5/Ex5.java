
package pt.ipp.estg.ed.ex5;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 *
 * @author SandroCunha8200785
 */
public class Ex5 {

    public static void main(String[] args) throws QueueEmptyException, DifferentArraysSizeException, QueueFullException {
        MessageCodificator mc = new MessageCodificator("Tboesp", new int[]{1,1,1,1,1,1});
        
        System.out.println(mc.message.toString());
        System.out.println(mc.message.size());
        System.out.println(mc.MessageDecodifier());
    }
}
