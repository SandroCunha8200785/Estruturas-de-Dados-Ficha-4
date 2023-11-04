
package pt.ipp.estg.ed.ex3;

import Exceptions.QueueEmptyException;

/**
 * Classe que une os valores de duas filas ordenadas, resultando numa fila tambem ordenada
 * @author SandroCunha8200785
 */
public class MergeQueues {
    /**
     * Primeira fila
     */
    private LinkedQueue<Integer> queueA;
    /**
     * Segunda fila.
     */
    private LinkedQueue<Integer> queueB;
    
    /**
     * Contrutor
     * @param queueA fila 1
     * @param queueB fila 2
     */
    public MergeQueues(LinkedQueue<Integer> queueA, LinkedQueue<Integer> queueB) {
        
        this.queueA = queueA;
        this.queueB = queueB;
        
    }
    
    /**
     * Metodo que une ordenadamente duas filas tambem ordenadas
     * @return fila LinkedQueue resultante das duas filas 
     * @throws QueueEmptyException 
     */
    public LinkedQueue mergeQueues() throws QueueEmptyException{
        
        LinkedQueue<Integer> queueFinal = new LinkedQueue<Integer>();
        
        //Enquanto ambas as filas não estiverem vazias
        while(!this.queueA.isEmpty() || !this.queueB.isEmpty()){
            
            //Caso ambas as filas tenham elementos
            if(!this.queueA.isEmpty() && !this.queueB.isEmpty()){
                
                //Caso o elemento da fila A seja menor ou igual, insere na lista nova
                if(this.queueA.first().compareTo(this.queueB.first()) <= 0){
                    queueFinal.enqueue(this.queueA.dequeue());
                    
                }
                
                else{
                    //Caso o elemento da fila B seja menor insere na lista nova
                    queueFinal.enqueue(this.queueB.dequeue());
                    
                }
            }
            
            //Fila A ainda não está vazia
            else if(!this.queueA.isEmpty()){
                queueFinal.enqueue(this.queueA.dequeue());
            }
            
            //Fila B ainda não está vazia
            else{
                queueFinal.enqueue(this.queueB.dequeue());
            }
        }
        
        return queueFinal;
        
    }
    
    
    
}
