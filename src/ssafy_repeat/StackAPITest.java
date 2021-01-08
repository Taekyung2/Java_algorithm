package ssafy_repeat;

import java.util.Stack;

public class StackAPITest {

    public static void main(String[] args) {

        String expression = "6528-*2/+";
        Stack<Integer> stk = new Stack<>();

        System.out.println(expression);

        int size = expression.length();

        for(int i = 0; i < size; i++) {
           char temp = expression.charAt(i);
           if(Character.isDigit(temp)) {
               stk.push(temp - '0');
           }
           else {
               int value2 = stk.pop();
               int value1 = stk.pop();

               switch(temp) {
                   case '+':
                       stk.push(value1 + value2);
                       break;
                   case '-':
                       stk.push(value1 - value2);
                       break;
                   case '*':
                       stk.push(value1 * value2);
                       break;
                   case '/':
                       stk.push(value1 / value2);
                       break;
               }
           }
        }
        System.out.println(stk.pop());
    }
}
