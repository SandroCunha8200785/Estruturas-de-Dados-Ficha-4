
package pt.ipp.estg.ed.ex3;

import Exceptions.QueueEmptyException;

/**
 *
 * @author sssan
 */
public class Ex3 {

    public static void main(String[] args) throws QueueEmptyException {
        
        LinkedQueue<Integer> a = new LinkedQueue<Integer>();
        LinkedQueue<Integer> b = new LinkedQueue<Integer>();
        
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(2);
        a.enqueue(3);
        
        
        b.enqueue(2);
        b.enqueue(3);
        b.enqueue(4);
        b.enqueue(5);
        b.enqueue(6);
        b.enqueue(7);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        
        LinkedQueue<Integer> c = new MergeQueues(a, b).mergeQueues();
        System.out.println(c.toString());
    }
}
