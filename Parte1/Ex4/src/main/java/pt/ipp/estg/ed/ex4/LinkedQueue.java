
package pt.ipp.estg.ed.ex4;

import Exceptions.QueueEmptyException;

/**
 * Fila com ista ligada que usa dois tipos parametrizados
 * @author Sandro Cunha 8200785
 */
public class LinkedQueue<T, U> implements QueueADT<T, U> {
    
    
//----------------ClASSE PRIVADA DE NOS DA FILA-----------------------------
    /**
     * Classe para os nós da lista
     * @param <T> tipo parametrizado 1
     * @param <U> tipo parametrizado 2
     */
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
    /**
     * Nó com dois tipos parametrizados
     */
    private Node<T, U> head, tail;
    /**
     * nr de elementos
     */
    private int nElem;

    //------------------------CONSTRUTOR--------------------------------------
    
    /**
     * Construtor vazio
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.nElem = 0;
    }
    
    
    //-----------------------METODOS DA INTERFACE-------------------------------
    
    /**
     * Insere no fim da fila um novo nó com os dois tipos parametrizados
     * @param element1 elemento 1
     * @param element2 elemento q
     * @throws NullPointerException elemento inexistente 
     */
    @Override
    public void enqueue(T element1, U element2) throws NullPointerException {
        if (element1 == null || element2 == null) {
            throw new NullPointerException();
        }
        
        //Inicialização do no com dois elementos
        Node<T, U> newNode = new Node<T, U>(element1, element2);
        
        //Caso a fila esteja vazia
        if (this.tail == null) {
            this.head = newNode;
        } 
        //Insere no fim da fila ja com elementos existentes
        else {
            this.tail.next = newNode;
        }
        
        this.tail = newNode;
        this.nElem++;
    }

    /**
     * Elimina da fila o elemento na cabeça
     * @return elemento eliminado
     * @throws QueueEmptyException fila vazia 
     */
    @Override
    public Node<T, U> dequeue() throws QueueEmptyException{
        
        if(this.isEmpty()) throw new QueueEmptyException();
        
        Node<T, U> node = this.head;
        this.head = this.head.next;
        
        if(this.head == null) this.tail = null;
        
        this.nElem--;
        return node;
        
    }
    
    /**
     * Mostra o primeiro elemento
     * @return elemento na cabeça da fila
     */
    @Override
    public  Node<T, U> first() {
        
        Node<T, U> node = this.head;
        
        return node;
        
    }
    
    /**
     * 
     * @return true se a fila está vazia
     */
    @Override
    public boolean isEmpty() {
        
        return this.head == null;
        
    }
    
    /**
     * 
     * @return nr de elemetos na fila 
     */
    @Override
    public int size() {
        
        return this.nElem;
        
    }
    
    /**
     * 
     * @return textualização dos dados na lista
     */
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
