package Ejercicio_01_sign;
import java.util.Stack;

public class SignValidator {

    public boolean isValid(String cadena){
        Stack<Character> pila = new Stack<Character>();
        for (int i = 0; i < cadena.length(); i++) {
            char temp = cadena.charAt(i);
            if(temp == '('||temp == '['||temp == '{'){//apertura
                pila.push(temp);
            } else if (temp == ')' || temp == ']' || temp == '}') {//de cierre
                if(pila.isEmpty()){
                    return false;
                }
                if(pila.peek() == '(' && temp==')'){
                    pila.pop();
                }else if(pila.peek() == '[' && temp==']'){
                    pila.pop();
                } else if (pila.peek() == '{' && temp=='}') {
                    pila.pop();
                }
            }else{
                return false;
            }
        }
        if(pila.isEmpty()){
            return true;
        }
        return false;
    }
        //Cadena = "(){}[";

        //char primero = '(';

        //Primero es de apertura o cierre
        //true
        //si es true agrego a pila
        // --------------- pila -> (
        //segundo ) es de apertura o cierre
        //false
        //si es true agrego a pila
        // comparo y pregunto es del mismo tipo
        // -> true retiro de la pila
        // -> false No es valido

        //Cadena = "]";

        //Cadena = "({[]})";
        // pila ---> (
        // pila ---> ( - {
        // pila ---> ( - { - [
        // char ]
        // comparo con el ultimo de la pila
        // ] es contrario a [
        // char ]
        // comparo con el ultimo de la pila
        // pila ---> ( - {
        // } es contrario a ese {
        // pila ---> (
    
}
