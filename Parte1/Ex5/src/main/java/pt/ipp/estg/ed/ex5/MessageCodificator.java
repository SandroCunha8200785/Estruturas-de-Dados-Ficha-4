
package pt.ipp.estg.ed.ex5;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 * Codificador de mensagem usando um array circular
 * @author SandroCunha8200785
 */
public class MessageCodificator {
    
    /**
     * Array Circular com a mensagem
     */
    public CircularArrayQueue message;
    /**
     * Cifra do codigo
     */
    private int[] code;
    
    
    /**
     * Construtor que recebe mensagem a codificar e a respetiva cifra
     * @param message mensagem
     * @param code cifra
     * @throws DifferentArraysSizeException Arrays de tamanhos diferentes 
     */
    public MessageCodificator(String message, int[] code) throws DifferentArraysSizeException, QueueFullException {
        
//Arrays com mesmo size
        if(message.length() == code.length){
           
            //Inicializa a fila com o tamanho da mensagem
            this.message = new CircularArrayQueue<Character>(message.length());
            this.code = new int[code.length];
            
            for(int i = 0; i < message.length(); i++){
                //Insere os caracteres na fila e os digitos da cifra no array
                this.message.enqueue(message.charAt(i));
                this.code[i] = code[i];
            }
        }
        
        else throw new DifferentArraysSizeException();
    }
    
    /**
     * Codifica a mensagem 
     * @return String com a mensagem codificada
     * @throws QueueEmptyException fila vazia
     */
    public String MessageCodifier() throws QueueEmptyException{
        
        StringBuilder str = new StringBuilder();
        
        //Percorre o array
        for(int i = 0; i < this.code.length ; i++){
            
            //Retira o caracter da fila
            char c = (char) this.message.dequeue();
            //Desloca n posiçoes
            char result = (char) (c + this.code[i]);
            
            //Insere na string
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
        
        //Percorre o array
        for(int i = 0; i < this.code.length ; i++){
            
            char c = (char) this.message.dequeue();
            // Recua o caracter 
            char result = (char) (c - this.code[i]);
            
            //Insere na String
            str.append(result);
        }
        
        return str.toString();
    }
    
}
