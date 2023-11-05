
package pt.ipp.estg.ed.ex2;

import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 *
 * @author SandroCunha8200785
 */
public class Ex2 {

    public static void main(String[] args) throws NullPointerException, QueueFullException, QueueEmptyException {
        Person p1 = new Person("Sandro", 31, 80.0);
        Person p2 = new Person("Fernanda", 26, 65.0);
        Person p3 = new Person("Diana", 29, 60.0);
        Person p4 = new Person("Augusto", 62, 90.0);
        Person p5 = new Person("Maria", 57, 56.0);
        Person p6 = new Person();
        Person p7 = new Person(p1);
        Person p8 = new Person("Andre", 36, 50.0);
        
        CircularArrayQueue<Person> queue = new CircularArrayQueue<Person>(5);
        
        queue.enqueue(p1);
        queue.enqueue(p2);
        queue.enqueue(p3);
        queue.enqueue(p4);
        
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        queue.enqueue(p1);
        queue.enqueue(p2);
        queue.enqueue(p3);
        System.out.println(queue.isEmpty());
        
        //System.out.println(queue.first());
        System.out.println(queue.size());
        
        System.out.println(queue.toString());
        
        System.out.println(queue.ArrayToString());
    }
}
