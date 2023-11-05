
package pt.ipp.estg.ed.ex2;

import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 * Classe que representa uma Queue com recurso a um array circular
 * @author sssan
 */
public class CircularArrayQueue<T> implements QueueADT<T>{
    
    /**
     * array
     */
    private T[] queue;
    /**
     * Posição da cabeça da fila
     */
    private int head;
    /**
     * Posição de fim da fila
     */
    private int tail;
    /**
     * nr de elementos efetivos na fila
     */
    private int nElem;
    
    /**
     * Construtor da queue
     * @param pSize tamanho do array circular
     * @throws NegativeArraySizeException tamanho do array tem se ser um interio positivo
     */
    public CircularArrayQueue(int pSize) throws NegativeArraySizeException{
        
        if(pSize<=0) throw new NegativeArraySizeException(); 
        //Inicializa o array    
        this.queue = (T[]) new Object[pSize];
        //Cabeça "aponta" para fora da fila
        this.head = this.queue.length;
        //Cauda na proxima posição a inserir, neste caso, na 0 porque esta vazia
        this.tail = 0;
        //Sem elementos ainda
        this.nElem = 0;
        
    }
    
    /**
     * Faz a inserção de um novo elemento no array (fila) na posição da cauda
     * @param element elemento a inserir
     * @throws NullPointerException elemento inexistente
     * @throws QueueFullException fila cheia
     */
    @Override
    public void enqueue(T element) throws NullPointerException, QueueFullException{
        
        if(element == null) throw new NullPointerException(); //elemento inexistente
        if(this.isFull()) throw new QueueFullException(); //fila cheia
        
        //Insere na cauda
        this.queue[this.tail] = element;
        
        //Caso seja o primeiro elemento, atualizar a cabeça
        if(this.isEmpty()) this.head = this.tail;
        
        /*Incrementar a cauda, caso ela esteja no final do array, deve voltar á posição 0, fazendo uma "volta" */
        this.tail = ++this.tail % this.queue.length;
        
        //Incrementar o nr de elementos
        this.nElem++;
        
    }
    
    /**
     * Operação que remove o elemento na cabeça da fila
     * @return Elemento eliminado
     * @throws QueueEmptyException fila vazia 
     */
    @Override
    public T dequeue() throws QueueEmptyException {
        
        if(this.isEmpty()) throw new QueueEmptyException(); //A fila esta vazia
        
        //Copiar o elemento a ser eliminado
        T elem = this.queue[this.head];
        
        //Colocar a cabeça a apontar para null, ou seja, remover o elemento nesta posiçao do array
        this.queue[this.head] = null;
        
        //Incrementar a cabeça para "apontar" para o elemento seguinte. Caso esteja no final do array, deve voltar ao inicio 
        this.head = ++this.head % this.queue.length;
        this.nElem--;
        
        //Caso a fila fique vazia, colocar a cabeça "fora da fila"
        if(this.isEmpty()) this.head = this.queue.length; 
        
        return elem;
        
    }
    
    /**
     * Mostra o elemento na cabeça da fila
     * @return elemento na cabeça da fila.
     * @throws QueueEmptyException fila vazia
     */
    @Override
    public T first() throws QueueEmptyException{
        
        if(this.isEmpty()) throw new QueueEmptyException();//fila vazia
        
        T elem = this.queue[this.head];
        
        return elem;
        
    }
    
    /**
     * 
     * @return true se a fila está vazia 
     */
    @Override
    public boolean isEmpty() {
        
        //A fila está vazia se a cabeça esta a apontar para fora da fila
        return this.head == this.queue.length;

    }
    
    /**
     * 
     * @return Nr de elementos na lista 
     */
    @Override
    public int size() {
        
        return this.nElem;
    
    }
    
    /**
     * 
     * @return true se a fila esta cheia 
     */
    @Override
    public boolean isFull() {
        
        //A fila esta cheia se a posição da cauda dá uma volta completa e atinge a posição da cabeça
        return this.head == this.tail;

    }
    
    
    //-------------------OVERRIDE DE OBJECT-------------------------------------
    
    /**
     * Print com os dados e elementos da fila
     * @return textualização da fila
     */
    @Override
    public String toString() {
        
        if(this.isEmpty()) return "\nLista Circular Vazia.\n";
        
        StringBuilder s = new StringBuilder("\n-------CIRCULAR LIST-----------\n");
        
        s.append("\nNr de Elemetos: ").append(this.nElem).append("\n");
        s.append("\nHead: ").append(this.queue[this.head].toString()).append("\n");
        
        //Se a cauda não é 0, entao o elemento na cauda está na posição tail-1
        if(this.tail > 0){
            
            s.append("\nTail: ").append(this.queue[this.tail - 1].toString()).append("\n");
            
            for(int i = this.head; i != this.tail; i = (++i % this.queue.length)){
                s.append(this.queue[i].toString()).append("\n");
            }
        }
        
        //Se a cauda é 0, significa que o ulimo elemento inserido está no final do array, e o apontador voltou ao 0
        else{ 
        
            s.append("\nTail: ").append(this.queue[this.queue.length - 1].toString()).append("\n");
        
            for(int i = this.head; i < this.queue.length; i++){
                s.append(this.queue[i].toString()).append("\n");
            }
        
        }
        
        
        return s.toString();
        
    }
    
    /**
     * Função auxiliar que printa o array para uma melhor compreensão do funcionamento do mesmo
     * @return textualização do funcionamento do array
     */
    public String ArrayToString(){
        
        StringBuilder s = new StringBuilder("\nElementos do vetor\n");
        for(int i = 0; i < this.queue.length; i++){
            if(this.queue[i] == null) s.append("\nPosição " + i + ": ").append("NULL").append("\n");
            else s.append("\nPosição " + i + ": ").append(this.queue[i].toString()).append("\n");
        }
        
        return s.toString();
    }
    
    
    
}
