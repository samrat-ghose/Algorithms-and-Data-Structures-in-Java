package me.ramswaroop.common;


import java.util.EmptyStackException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/24/15
 * Time: 3:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */

/**
 * Stack implementation using
 * a singly linked list
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     */
    @Override
    public E push(E item) {
        top = new Node<>(item, top);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return
     */
    @Override
    public E pop() {
        E item = peek();
        top = top.next;
        return item;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return
     */
    @Override
    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return
     */
    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    /**
     * Prints the content of the stack.
     */
    @Override
    public void print() {
        Node<E> node;
        System.out.print("[");
        if (top == null) {
            System.out.print("]");
            return;
        }
        for (node = top; node.next != null; node = node.next) {
            System.out.print(node.value + ",");
        }
        System.out.println(node.value + "]");
    }

    /**
     * Tests if this stack is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
