/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.ed.ex5;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 *
 * @author sssan
 */
public class MessageCodificator {
    
    public CircularArrayQueue message;
    private int[] code;

    public MessageCodificator(String message, int[] code) throws DifferentArraysSizeException, QueueFullException {
        
        if(message.length() == code.length){
           
            this.message = new CircularArrayQueue<Character>(message.length());
            this.code = new int[code.length];
            
            for(int i = 0; i < message.length(); i++){
                this.message.enqueue(message.charAt(i));
                this.code[i] = code[i];
            }
        }
        
        else throw new DifferentArraysSizeException();
    }
    
    
    public String MessageCodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < this.code.length ; i++){
            
            char c = (char) this.message.dequeue();
            
            char result = (char) (c + this.code[i]);
            
            System.out.println(result + "+" + i);
            
            str.append(result);
        }
        
        return str.toString();
    }
    
    public String MessageDescodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < this.code.length ; i++){
            
            char c = (char) this.message.dequeue();
            
            char result = (char) (c - this.code[i]);
            
            System.out.println(result);
            
            str.append(result);
        }
        
        return str.toString();
    }
    
}
