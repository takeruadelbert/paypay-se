/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablequeue;

/**
 *
 * @author Lukas Fam
 */
public interface Queue<T> {

    public Queue<T> enQueue(T t);

    public Queue<T> deQueue();

    public T head();

    public boolean isEmpty();
}
