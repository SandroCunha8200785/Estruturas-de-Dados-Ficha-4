
package pt.ipp.estg.ed.ex5;

import Exceptions.QueueEmptyException;

/**
 * Classe que une os valores de duas filas ordenadas, resultando numa fila tambem ordenada
 * @author SandroCunha8200785
 */
public class MergeQueues {
    /**
     * Fila que contem varias filas, cada uma contendo uma string
     */
    private LinkedQueue<LinkedQueue<String>> queue;
    
    
    /**
     * Construtor recebe por parametro as fila de filas de string
     * 
     */
    public MergeQueues(LinkedQueue<LinkedQueue<String>> queue){
        
       this.queue = queue;
        
    }
    
    /**
     * Metodo que transforma varias filas de Strings numa unica
     * @return fila LinkedQueue resultante das varias filas
     * @throws QueueEmptyException 
     */
    public void mergeQueues() throws QueueEmptyException{
        
        //Filas auxiliares
        LinkedQueue<String> newQueue1 = new LinkedQueue<String>();
        LinkedQueue<String> newQueue2 = new LinkedQueue<String>();
        
        //Enquanto a lista não tiver apenas uma unica fila
        while (this.queue.size() > 1) {
            
            //Retira da fila os primeiros dois elementos
            newQueue1 = this.queue.dequeue();
            newQueue2 = this.queue.dequeue();
            
            //Chamada da função auxiliar para colocar no fim da fila a lista dos dois primeiros elemetos mesclados
            this.queue.enqueue(this.mergeTwoQueues(newQueue1, newQueue2));
        }
        
    }
    
    /**
     * Função auxiliar que converte duas filas de string numa unica
     * @param list1 fila 1 de Strings
     * @param list2 fila 2 de Strings
     * @return Lista com as duas filas mescladas
     * @throws QueueEmptyException 
     */
    private LinkedQueue<String> mergeTwoQueues(LinkedQueue<String> list1, LinkedQueue<String> list2) throws QueueEmptyException{
        
        while(!list2.isEmpty()){
            list1.enqueue(list2.dequeue());
        }
    
        return list1;
    }
    
    /**
     * Metodo toString
     * @return 
     */
    @Override
    public String toString() {
        if(this.queue.isEmpty()) return "\nLista Vazia\n";
        
        StringBuilder s = new StringBuilder("\n------MERGE LIST---------");
        
        s.append("Nr Elements: ").append(this.queue.size()).append("\n");
        
        s.append(this.queue.toString()).append("\n");
        
        return s.toString();
    }
    
    
    
    
    
    
}
