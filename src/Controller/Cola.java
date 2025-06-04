package Controller;
import java.util.EmptyStackException;

import Models.Node;
public class Cola {
    private Node inicio;
    private Node fin;
    public int size;

    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return inicio == null;
    }

    public void add(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            inicio = newNode;
            fin = newNode;
        }else{
            fin.setNext(newNode);
            fin = newNode;
        }
        size++;
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        int value = inicio.getValue();
        inicio = inicio.getNext();
        size--;
        return value;
    }

    public int peek(){
        if (isEmpty())
            throw new EmptyStackException();
        return inicio.getValue();
    }


    public void printCola(){
        Node current = inicio;
        while(current != null){
            System.out.print(current.getValue() + " | ");
            current = current.getNext();
        }
        System.out.println();
    }
    public int size(){
        return size;
    }

    
}