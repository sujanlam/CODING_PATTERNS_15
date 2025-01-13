package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String parens = "{()({})}[]";
        System.out.println(isValidParenthesis(parens));
    }
    public static boolean isValidParenthesis(String s){
        Deque<Character> stackOfChar = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            if(!stackOfChar.isEmpty()){

            }
            if(c == ']' && stackOfChar.peek()=='['
            || c == ')' && stackOfChar.peek()=='('
            || c == '}' && stackOfChar.peek()=='{'){
                stackOfChar.pop();
            }else {
                stackOfChar.push(c);
            }
        }
        return stackOfChar.isEmpty();
    }
}
