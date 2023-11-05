
package pt.ipp.estg.ed.ex2;

import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 * 
 * @author SandroCunha8200785
 */
public interface QueueADT<T> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element) throws NullPointerException, QueueFullException;

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     */
    public T dequeue() throws QueueEmptyException;

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    public T first() throws QueueEmptyException;

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns true if the queue array has no room for more elements.
     *
     * @return true if the queue is full
     */
    
    public boolean isFull();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    public String toString();
}

