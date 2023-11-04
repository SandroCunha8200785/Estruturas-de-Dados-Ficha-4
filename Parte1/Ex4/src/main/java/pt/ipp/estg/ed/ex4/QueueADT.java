/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.ed.ex4;

import Exceptions.QueueEmptyException;
import pt.ipp.estg.ed.ex4.LinkedQueue.Node;


/**
 *
 * @author sssan
 */
public interface QueueADT<T, U> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element1, U element2) throws NullPointerException;

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     */
    public Node<T, U> dequeue() throws QueueEmptyException;

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    public  Node<T, U> first();

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty();

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
    @Override
    public String toString();
}
