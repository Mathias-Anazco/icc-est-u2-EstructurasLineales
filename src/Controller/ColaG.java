package Controller;
import java.util.EmptyStackException;

import Models.NodeGeneric;

public class ColaG<T> {
    private NodeGeneric<T> inicio;
    private NodeGeneric<T> fin;
    private int size;

    public ColaG() {
        this.inicio = null;
        this.fin = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void add(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if (isEmpty()) {
            inicio = newNode;
            fin = newNode;
        } else {
            fin.setNext(newNode);
            fin = newNode;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        T value = inicio.getValue();
        inicio = inicio.getNext();
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return inicio.getValue();
    }

    public void printCola() {
        NodeGeneric<T> current = inicio;
        while (current != null) {
            System.out.print(current.getValue() + " - ");
            current = current.getNext();
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
