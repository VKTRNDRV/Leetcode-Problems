package easy.validParenthesis;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        Stack<Character> parenthesis = new Stack<>();
        int strLength = s.length();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar){
                case '{':
                case '[':
                case '(':
                    parenthesis.push(currentChar);
                    break;

                case '}':
                    if(parenthesis.isEmpty()) return false;
                    if(parenthesis.pop() != '{') return false;
                    break;
                case ']':
                    if(parenthesis.isEmpty()) return false;
                    if(parenthesis.pop() != '[') return false;
                    break;
                case ')':
                    if(parenthesis.isEmpty()) return false;
                    if(parenthesis.pop() != '(') return false;
                    break;

                default:
                    break;
            }
        }

        return parenthesis.isEmpty();
    }
}
