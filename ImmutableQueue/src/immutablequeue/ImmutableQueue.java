/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablequeue;

import java.util.NoSuchElementException;

/**
 *
 * @author Lukas Fam
 */
public final class ImmutableQueue<T> implements Queue<T> {

    private Stack<T> forward;
    private Stack<T> reverse;

    public ImmutableQueue() {
        this.forward = new Stack<>();
        this.reverse = new Stack<>();
    }

    private ImmutableQueue(Stack<T> forward, Stack<T> reverse) {
        this.forward = forward;
        this.reverse = reverse;
    }

    @Override
    public Queue<T> enQueue(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        return new ImmutableQueue<T>(this.forward.push(t), this.reverse);
    }

    @Override
    public Queue<T> deQueue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (!this.reverse.isEmpty()) {
            return new ImmutableQueue<>(this.forward, this.reverse.tail);
        } else {
            return new ImmutableQueue<>(new Stack<>(), this.forward.reverseStack().tail);
        }
    }

    @Override
    public T head() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (this.reverse.isEmpty()) {
            this.reverse = this.forward.reverseStack();
            this.forward = new Stack<>();
        }
        return this.reverse.head;
    }

    @Override
    public boolean isEmpty() {
        return (this.forward.size + this.reverse.size) == 0;
    }

    private final class Stack<T> {

        private final T head;
        private final Stack<T> tail;
        private final int size;

        private Stack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        private Stack(T head, Stack<T> tail) {
            this.head = head;
            this.tail = tail;
            this.size = tail.size + 1;
        }

        private final boolean isEmpty() {
            return this.size == 0;
        }

        private final Stack<T> push(T t) {
            return new Stack<>(t, this);
        }

        private final Stack<T> reverseStack() {
            Stack<T> newStack = new Stack<>();
            Stack<T> tail = this;
            while (!tail.isEmpty()) {
                newStack = newStack.push(tail.head);
                tail = tail.tail;
            }
            return newStack;
        }
    }
}
