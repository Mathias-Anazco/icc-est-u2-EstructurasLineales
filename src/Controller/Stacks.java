package Controller;
import java.util.EmptyStackException;

import Models.Node;

public class Stacks {
    private Node top;
    private int size;

    public Stacks(){
        this.top = null;
        this.size = 0;
    }

    //Metodo que ingrese a un valor int
    public void push(int value){
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
        
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.println(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public int size(){
        return size;
    }
}
