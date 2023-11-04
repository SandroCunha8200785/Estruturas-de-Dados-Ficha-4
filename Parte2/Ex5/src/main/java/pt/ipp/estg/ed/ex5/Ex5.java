
package pt.ipp.estg.ed.ex5;

import Exceptions.QueueEmptyException;

/**
 *
 * @author sssan
 */
public class Ex5 {

    public static void main(String[] args) throws QueueEmptyException {
        
        LinkedQueue<String> list1 = new LinkedQueue<String>();
        list1.enqueue("Um ");
        LinkedQueue<String> list2 = new LinkedQueue<String>();
        list2.enqueue("Dois ");
        LinkedQueue<String> list3 = new LinkedQueue<String>();
        list3.enqueue("Tres  ");
        LinkedQueue<String> list4 = new LinkedQueue<String>();
        list4.enqueue("Quatro ");
        LinkedQueue<String> list5 = new LinkedQueue<String>();
        list5.enqueue("Cinco ");
        
        LinkedQueue<LinkedQueue<String>> queue = new LinkedQueue<LinkedQueue<String>>();
        
        queue.enqueue(list1);
        queue.enqueue(list2);
        queue.enqueue(list3);
        queue.enqueue(list4);
        queue.enqueue(list5);
        
       
        MergeQueues mq = new MergeQueues(queue);
        mq.mergeQueues();
        System.out.println(mq.toString());
    }
}
