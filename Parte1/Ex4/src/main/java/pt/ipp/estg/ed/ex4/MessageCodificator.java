
package pt.ipp.estg.ed.ex4;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import pt.ipp.estg.ed.ex4.LinkedQueue.Node;

/**
 * Codificador de mensagens
 * @author SandroCunha8200785
 */
public class MessageCodificator {
    
    /**
     * Fila com lista ligada de parametro duplo
     */
    public LinkedQueue<Character, Integer> codifier;
    
    /**
     * Construtor que recebe mensagem a codificar e a respetiva cifra
     * @param message mensagem
     * @param code cifra
     * @throws DifferentArraysSizeException Arrays de tamanhos diferentes 
     */
    public MessageCodificator(String message, int[] code) throws DifferentArraysSizeException {
        
        //Arrays com mesmo size
        if(message.length() == code.length){
            
            //Inicializa a lista
            this.codifier = new LinkedQueue<Character, Integer>();
            
            //Corre a mensagem a cada caracter
            for(int i = 0; i < message.length(); i++){
                //Insere na fila o no com o caracter e o respetivo digito da cifra
                this.codifier.enqueue(message.charAt(i), code[i]);
            }
        }
        
        else throw new DifferentArraysSizeException();
    }
    
    /**
     * Codifica a mensagem presente no objecto
     * @return String com mensagem codificada
     * @throws QueueEmptyException  fila vazia
     */
    public String MessageCodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        //Enquanto a fila tiver elementos
        while(!this.codifier.isEmpty()){
            
            Node<Character, Integer> node = this.codifier.dequeue();
            
            char c = node.getElem1();
            int n = node.getElem2();
            //DEsloca o caracter n posições
            char result = (char) (c + n);
            
            
            //Acrescenta na string resultante
            str.append(result);
        }
        
        return str.toString();
    }
    
    /**
     * Descodifica uma mensagem
     * @return mensagem descodificada
     * @throws QueueEmptyException fila vazia
     */
    public String MessageDecodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        //Enquanto a fila tiver elementos
        while(!this.codifier.isEmpty()){
            
            Node<Character, Integer> node = this.codifier.dequeue();
            
            char c = node.getElem1();
            int n = node.getElem2();
            //Recua o caracter n posições
            char result = (char) (c - n);
            
            
            //Acrescenta na string resultante
            str.append(result);
        }
        
        return str.toString();
    }
    
    
}