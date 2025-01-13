package stacks;

import utilities.PrintData;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "faacabbacfdello";
        System.out.println(removeDups(s));
    }

    public static String removeDups(String s) {
        Stack<Character> charStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!charStack.isEmpty() && c == charStack.peek()){
                charStack.pop();
            }else {
                charStack.push(c);
            }
        }
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }
}
