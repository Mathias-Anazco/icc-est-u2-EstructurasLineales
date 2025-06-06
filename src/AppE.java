import java.util.Stack;

import Ejercicio_01_sign.SignValidator;
import Ejercicio_02_sorting.StackSorter;

public class AppE {
        public static void main(String[] args) {
        SignValidator signValidator = new SignValidator();
        System.out.println(signValidator.isValid("()"));          
        System.out.println(signValidator.isValid("{[()]}"));       
        System.out.println(signValidator.isValid("{[(])}"));       
        System.out.println(signValidator.isValid("((())")); 


        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        StackSorter sorter = new StackSorter();
        sorter.sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
}
