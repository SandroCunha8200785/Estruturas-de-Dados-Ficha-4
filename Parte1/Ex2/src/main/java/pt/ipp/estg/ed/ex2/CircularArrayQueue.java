/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.ed.ex2;

import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 *
 * @author sssan
 */
public class CircularArrayQueue<T> implements QueueADT<T>{
    
    private T[] queue;
    private int head;
    private int tail;
    private int nElem;

    public CircularArrayQueue(int pSize) throws NegativeArraySizeException{
        
        if(pSize<=0) throw new NegativeArraySizeException(); 
            
        this.queue = (T[]) new Object[pSize];
        this.head = this.queue.length;
        this.tail = 0;
        this.nElem = 0;
        
    }

    @Override
    public void enqueue(T element) throws NullPointerException, QueueFullException{
        
        if(element == null) throw new NullPointerException();
        if(this.isFull()) throw new QueueFullException();
        
        this.queue[this.tail] = element;
        if(this.isEmpty()) this.head = this.tail;
        this.tail = ++this.tail % this.queue.length;
        this.nElem++;
        
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        
        if(this.isEmpty()) throw new QueueEmptyException();
        
        T elem = this.queue[this.head];
        this.queue[this.head] = null;
        this.head = ++this.head % this.queue.length;
        this.nElem--;
        
        if(this.isFull()) this.head = this.queue.length; 
        
        return elem;
        
    }

    @Override
    public T first() throws QueueEmptyException{
        
        if(this.isEmpty()) throw new QueueEmptyException();
        
        T elem = this.queue[this.head];
        
        return elem;
        
    }

    @Override
    public boolean isEmpty() {

        return this.head == this.queue.length;

    }

    @Override
    public int size() {
        
        return this.nElem;
    
    }

    @Override
    public boolean isFull() {

        return this.head == this.tail;

    }
    
    
    //-------------------OVERRIDE DE OBJECT-------------------------------------

    @Override
    public String toString() {
        
        if(this.isEmpty()) return "\nLista Circular Vazia.\n";
        
        StringBuilder s = new StringBuilder("\n-------CIRCULAR LIST-----------\n");
        
        s.append("\nNr de Elemetos: ").append(this.nElem).append("\n");
        s.append("\nHead: ").append(this.queue[this.head].toString()).append("\n");
        
        if(this.tail > 0){
            
            s.append("\nTail: ").append(this.queue[this.tail - 1].toString()).append("\n");
            
            for(int i = this.head; i != this.tail; i = (++i % this.queue.length)){
                s.append(this.queue[i].toString()).append("\n");
            }
        }
        
        else{ 
        
            s.append("\nTail: ").append(this.queue[this.queue.length - 1].toString()).append("\n");
        
            for(int i = this.head; i < this.queue.length; i++){
                s.append(this.queue[i].toString()).append("\n");
            }
        
        }
        
        
        return s.toString();
        
    }
    
    
    public String ArrayToString(){
        
        StringBuilder s = new StringBuilder("\nElementos do vetor\n");
        for(int i = 0; i < this.queue.length; i++){
            if(this.queue[i] == null) s.append("\nPosição " + i + ": ").append("NULL").append("\n");
            else s.append("\nPosição " + i + ": ").append(this.queue[i].toString()).append("\n");
        }
        
        return s.toString();
    }
    
    
    
}
