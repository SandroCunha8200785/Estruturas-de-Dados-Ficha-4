/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pt.ipp.estg.ed.ex4;

import Exceptions.QueueEmptyException;

/**
 *
 * @author sssan
 */
public class Ex4 {

    public static void main(String[] args) throws QueueEmptyException {
        
        TwoStackQueue<String> queue = new TwoStackQueue<String>();
        
        queue.enqueue("UM");
        queue.enqueue("DOIS");
        queue.dequeue();
        queue.enqueue("TRES");
        queue.enqueue("QUATRO");
        queue.dequeue();
        queue.enqueue("CINCO");
        System.out.println(queue.toString());
    }
}
