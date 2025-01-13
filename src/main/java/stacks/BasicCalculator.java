package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String parens = "18    - ( 7 + ( 2 - 4 ) )";
        System.out.println(calculate(parens));
    }

    public static int calculate(String s) {
        int result = 0;
        int cur_num = 0;
        int sign = 1;
        int answer = 0;
        Stack<Integer> numStack = new Stack<>();
        for (char c : s.toCharArray()) {
            //whitespace
            if(Character.isWhitespace(c)){
                continue;
            }
            //Digit
            if(Character.isDigit(c)){
                cur_num = cur_num * 10 + (c-'0');
            }

            //+ or -
            else if (c == '-' || c== '+') {
                result += cur_num * sign;
                sign = (c=='-')?-1:1;
                cur_num = 0;
            }

            // ( insert into the stack
            else if (c =='(') {
                numStack.push(result);
                numStack.push(sign);
                result = 0;
                sign = 1;
            }

            // ) start calculating
            else if (c==')') {
                result += cur_num*sign;
                result *= numStack.pop();
                result += numStack.pop();
                cur_num = 0;
            }
        }
        return result+ sign*cur_num;
    }
}
