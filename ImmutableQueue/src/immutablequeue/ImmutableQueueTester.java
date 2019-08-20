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
public class ImmutableQueueTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        queue = queue.enQueue(1);
        queue = queue.enQueue(2);
        queue = queue.enQueue(3);
        queue = queue.deQueue();
        System.out.println(queue.head());
        queue = queue.deQueue();
        System.out.println(queue.head());
        queue = queue.deQueue();
    }

}
