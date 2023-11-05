
package pt.ipp.estg.ed.ex4;

import Exceptions.QueueEmptyException;
import java.util.Stack;

/**
 *Classe que satisfaz a QueueADT usando duas pilhas
 * @author SandroCunha8200785
 */
public class TwoStackQueue<T> implements QueueADT<T>{
    
    /**
     * Pilha front que irá trabalhar com o elemento mais antigo no topo e o mais recente no fundo
     */
    private Stack<T> frontStack;
    
    /**
     * Pilha back com os elementos no sentido inverso, o mais recente no topo e o mais antigo no fundo
     */
    private Stack<T> backStack;

    /**
     * Construtor vazio inicia as duas pilhas
     */
    public TwoStackQueue() {
        
        this.frontStack = new Stack<>();
        this.backStack = new Stack<>();
        
    }

    /**
     * Este metodo começa por verificar que existem elementos na pilha back (inverso).
     * Se não existirem, é necessário colocar na pilha back os elementos, então só no fim
     * é colocado o novo elemento no topo pilha back.
     * Caso os elementos já se encontrem na pilha back, significa que a ultima operação
     * foi uma outra enqueue e basta colocar o novo elemento, mais recente, na pilha back.
     * @param element novo elemento a colocar
     */
    @Override
    public void enqueue(T element) {
        
        //verifica se back está vazia
        if(this.backStack.isEmpty()) {
            //Enquanto a pilha front não estiver vazia, coloca os invertidamente na pilha back
            while (!this.frontStack.isEmpty()) {
                this.backStack.push(this.frontStack.pop());
            }
            
        }
        
        //Coloca o elemento mais recente na pilha back
        this.backStack.push(element);
        
    }
    
    /**
     * VErifica se os elementos se encontram na pilha front primeiro, se estiverem lá
     * apenas faz o pop da pilha front, ou seja, o elemento mais antigo, caso contrario
     * eles estão na pilha back, sendo necessario passa-los invertidamente para a pilha front
     * antes de fazer o pop.
     * @return elemento eliminado (mais antigo)
     * @throws QueueEmptyException Excepção de não haverem elementos em qualquer das pilhas
     */
    @Override
    public T dequeue() throws QueueEmptyException {
        
        //Verifica se existe algum elemento
        if (this.isEmpty()) {
            throw new QueueEmptyException();
        }
        
        //Se a pilha front esta vazia
        if(this.frontStack.isEmpty()) {
            //Passar os elementos da pilha back para a front
            while (!this.backStack.isEmpty()) {
                this.frontStack.push(this.backStack.pop());
            }
            
        }
        
        //Faz o pop da pilha front(o elemento mais antigo)
        return this.frontStack.pop();
    }
    
    /**
     * Funciona da mesma forma que o Dequeue, mas neste caso não faz o pop, mas sim o peek
     * @return o elemento no topo da pilha front (mais antigo) sem o remover
     * @throws QueueEmptyException Excepção de não haverem elementos em qualquer das pilhas
     */
    @Override
    public T first() throws QueueEmptyException{
        
        if (this.isEmpty()) {
            throw new QueueEmptyException();
        }

        if (this.frontStack.isEmpty()) {
            while (!this.backStack.isEmpty()) {
                this.frontStack.push(this.backStack.pop());
            }
        }

        return this.frontStack.peek();
    }
    
    /**
     * Verifica se a fila esta vazia.
     * Fila vazia implica que não exista qualquer elemento em qualquer uma das stacks
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return this.frontStack.isEmpty() && this.backStack.isEmpty();
    }
    
    /**
     * Devolve o tamanho da fila, ou seja o tamanho das duas stacks
     * @return 
     */
    @Override
    public int size() {
        return this.frontStack.size() + this.backStack.size();
    }
    
    /**
     * 
     * @return Os valores contidos na fila 
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("\n-------TWO STACK QUEUE-------\n");
        
        //Se a pilha front estiver vazia, é necessario colocar os elementos por ordem inversa a pilha back
        if (this.frontStack.isEmpty()) {
            while (!this.backStack.isEmpty()) {
                this.frontStack.push(this.backStack.pop());
            }
        }
        
        //Tendo os elementos na pilha front, recolocar na back e ir registando um a um
        while (!this.frontStack.isEmpty()) {
            s.append(this.frontStack.peek().toString()).append("\n");
            this.backStack.push(this.frontStack.pop());
        }

        return s.toString();
    }
}

    
