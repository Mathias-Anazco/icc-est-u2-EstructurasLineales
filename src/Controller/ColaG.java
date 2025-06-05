package Controller;
import java.util.EmptyStackException;

import Models.NodeGeneric;
import Models.Persona;

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

    public int findByName(String nombre) {
        int posicion = 0;
        NodeGeneric<T> Node = inicio;  
        while (Node != null) {         
            if (Node.getValue().toString().equals(nombre)) {  
            return posicion;  
        }
        Node = Node.getNext();   
    }
    return -1;  
    }

public Persona removeByName(String nombre) {
    if (isEmpty()) {
        throw new EmptyStackException();
    }

    NodeGeneric<T> actual = inicio;
    NodeGeneric<T> anterior = null;

    while (actual != null) {
        T valor = actual.getValue();
        // Verifica que sea una Persona
        if (valor instanceof Persona) {
            Persona persona = (Persona) valor;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                // Si es el primer nodo
                if (anterior == null) {
                    inicio = actual.getNext();
                    if (inicio == null) {
                        fin = null;
                    }
                } else {
                    anterior.setNext(actual.getNext());
                    if (actual == fin) {
                        fin = anterior;
                    }
                }
                size--;
                return persona;
            }
        }
        anterior = actual;
        actual = actual.getNext();
    }
    return null; // Si no se encontró
}
}
