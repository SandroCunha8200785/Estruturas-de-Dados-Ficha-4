
package pt.ipp.estg.so.ex1;

import Exceptions.QueueEmptyException;



/**
 *Classe de lista ligada de tipos parametrizados comparaveis
 * @author SandroCunha8200785
 */
public class LinkedQueue<T> implements QueueADT<T> {
    
    
//----------------ClASSE PRIVADA DE NOS DA FILA-----------------------------
    /**
     * Classe privada dos nós da lista
     * @param <T> tipo parametrizado T
     */
    private static class Node<T>{
        //------------VARIAVEIS DE INSTANCIA DOS NOS------------------------------
        public Node<T> next;
        public T elem;
        //-----------------CONSTRUTOR DO NO-----------------------------------
        public Node(T pElem){
            this.elem = pElem;
            this.next = null;
        }
    }
    
    
    //---------------------ATRIBUTOS DE INSTANCIA DA FILA-----------------------
    
    private Node<T> head, tail;
    private int nElem;

    //------------------------CONSTRUTOR--------------------------------------
    
    /**
     * Construtor Vazio
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.nElem = 0;
    }
    
    
    //-----------------------METODOS DA INTERFACE-------------------------------
    
    /**
     * Operação Enqueue apenas se o elemento a inserir é maior do que a cauda, mantendo
     * a fila ordenada por ordem crescente.
     * @param element elemento a inserir
     * @throws NullPointerException elemento não existe
     */
    @Override
    public void enqueue(T element) throws NullPointerException{
        
        if(element == null) throw new NullPointerException();
        Node<T> newNode = new Node<T>(element);
        
        if(this.tail != null){
            
            this.tail.next = newNode;
            this.tail = newNode;
            this.nElem++;
            
        }
        
        //Insere caso seja o primeiro elemento, neste caso, não há valor anterior a comparar
        if(this.tail == null){ 
            
            this.head = newNode;
            this.tail = newNode;
            this.nElem++;
            
        }
            
            
        
    }

    /**
     * Metodo que retira o primeiro elemento da fila
     * @return elemento mais antigo na fila
     * @throws QueueEmptyException fila vazia
     */
    @Override
    public T dequeue() throws QueueEmptyException{
        
        if(this.isEmpty()) throw new QueueEmptyException();
        
        T elem = this.head.elem;
        this.head = this.head.next;
        
        if(this.head == null) this.tail = null;
        
        this.nElem--;
        return elem;
        
    }
    
    /**
     * 
     * @return primeiro elemento da fila
     */
    @Override
    public T first() {
        
        T elem = null;
        
        if(this.head != null) elem = this.head.elem;
        
        return elem;
        
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
     * @return nr de elemntos da fila 
     */
    @Override
    public int size() {
        
        return this.nElem;
        
    }
    
    
    //-----------METODOS DE OBJECT----------------------------------
    
    /**
     * 
     * @return String com o conteudo da lista 
     */
    @Override
    public String toString() {
        
        if(this.isEmpty()) return "\nLista Vazia.\n";
        
        StringBuilder s = new StringBuilder("\n--------LINKED LIST ---------------\n");
        s.append("Nr de elementos: ").append(this.nElem).append("\n");
        s.append("Head: ").append(this.head.elem.toString()).append("\n");
        s.append("Tail: ").append(this.tail.elem.toString()).append("\n");
        
        for(Node<T> node = this.head; node != null; node = node.next){
            s.append(node.elem.toString()).append("\n");
        }
        
        return s.toString();
    }
    
    
}
