package bank_management;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void addFirst(T data) {
    	// adds the node in the beginning
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
    	// adds the node in the last
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeLast() {
    	// removes the node from the linkedlist
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = tail = null;
        } else {
            previous.next = null;
            tail = previous;
        }
        size--;
        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void forEach(Consumer<? super T> action) {
    	//linkedlist traversal
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }
}

