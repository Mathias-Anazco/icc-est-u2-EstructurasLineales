package Ejercicio_02_sorting;

import java.util.Stack;

    public class StackSorter {
        public void sortStack(Stack<Integer> stack) {
        Stack<Integer> aux = new Stack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!aux.isEmpty() && aux.peek() > tmp) {
                stack.push(aux.pop());
            }
            aux.push(tmp);
        }
        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }
    }
    
}
