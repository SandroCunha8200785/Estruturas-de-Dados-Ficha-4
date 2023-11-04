/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.ed.ex4;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import pt.ipp.estg.ed.ex4.LinkedQueue.Node;

/**
 *
 * @author sssan
 */
public class MessageCodificator {
    
    public LinkedQueue<Character, Integer> codifier;

    public MessageCodificator(String message, int[] code) throws DifferentArraysSizeException {
        
        if(message.length() == code.length){
           
            this.codifier = new LinkedQueue<Character, Integer>();
            
            for(int i = 0; i < message.length(); i++){
                this.codifier.enqueue(message.charAt(i), code[i]);
            }
        }
        
        else throw new DifferentArraysSizeException();
    }
    
    
    public String MessageCodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        while(!this.codifier.isEmpty()){
            
            Node<Character, Integer> node = this.codifier.dequeue();
            
            char c = node.getElem1();
            int n = node.getElem2();
            char result = (char) (c + n);
            
            System.out.println(result);
            
            str.append(result);
        }
        
        return str.toString();
    }
    
    public String MessageDescodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        while(!this.codifier.isEmpty()){
            
            Node<Character, Integer> node = this.codifier.dequeue();
            
            char c = node.getElem1();
            int n = node.getElem2();
            char result = (char) (c - n);
            
            System.out.println(result);
            
            str.append(result);
        }
        
        return str.toString();
    }
    
    
}
