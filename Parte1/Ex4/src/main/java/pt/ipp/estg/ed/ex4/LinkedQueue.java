/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.ed.ex4;

import Exceptions.QueueEmptyException;

/**
 *
 * @author sssan
 */
public class LinkedQueue<T, U> implements QueueADT<T, U> {
    
    
//----------------ClASSE PRIVADA DE NOS DA FILA-----------------------------
    public static class Node<T, U> {

        private Node<T, U> next;
        private T elem1;
        private U elem2;

        public Node(T pElem1, U pElem2) {
            this.elem1 = pElem1;
            this.elem2 = pElem2;
            this.next = null;
        }

        public Node<T, U> getNext() {
            return next;
        }

        public T getElem1() {
            return elem1;
        }

        public U getElem2() {
            return elem2;
        }
        
        
    }
    
    
    //---------------------ATRIBUTOS DE INSTANCIA DA FILA-----------------------
    
    private Node<T, U> head, tail;
    private int nElem;

    //------------------------CONSTRUTOR--------------------------------------
    
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.nElem = 0;
    }
    
    
    //-----------------------METODOS DA INTERFACE-------------------------------
    
    @Override
    public void enqueue(T element1, U element2) throws NullPointerException {
        if (element1 == null || element2 == null) {
            throw new NullPointerException();
        }

        Node<T, U> newNode = new Node<T, U>(element1, element2);

        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.nElem++;
    }

    
    @Override
    public Node<T, U> dequeue() throws QueueEmptyException{
        
        if(this.isEmpty()) throw new QueueEmptyException();
        
        Node<T, U> node = this.head;
        this.head = this.head.next;
        
        if(this.head == null) this.tail = null;
        
        this.nElem--;
        return node;
        
    }

    @Override
    public  Node<T, U> first() {
        
        Node<T, U> node = this.head;
        
        return node;
        
    }

    @Override
    public boolean isEmpty() {
        
        return this.head == null;
        
    }

    @Override
    public int size() {
        
        return this.nElem;
        
    }

    @Override
    public String toString() {
        if(this.isEmpty()) return "\nLista vazia\n";
        
        StringBuilder s = new StringBuilder("\n---LISTA----\n");
        s.append("\nNr Elementos: ").append(this.nElem).append("\n");
        
        for(Node<T, U> node = this.head; node != null; node = node.next){
            s.append("Elem1: ").append(node.elem1.toString()).append(" \tElem2: ").append(node.elem2.toString()).append("\n");
        }
        
        return s.toString();
    }

    
}
