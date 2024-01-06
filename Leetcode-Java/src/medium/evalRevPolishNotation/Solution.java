package medium.evalRevPolishNotation;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        int firstNum, secondNum;
        for(String token : tokens){
            if(Objects.equals(token, "+")){
                secondNum = nums.pop();
                firstNum = nums.pop();
                nums.push(firstNum + secondNum);

            } else if (Objects.equals(token, "-")) {
                secondNum = nums.pop();
                firstNum = nums.pop();
                nums.push(firstNum - secondNum);

            } else if (Objects.equals(token, "*")) {
                secondNum = nums.pop();
                firstNum = nums.pop();
                nums.push(firstNum * secondNum);

            } else if (Objects.equals(token, "/")) {
                secondNum = nums.pop();
                firstNum = nums.pop();
                nums.push(firstNum / secondNum);

            }else{
                nums.push(Integer.parseInt(token));
            }
        }

        return nums.peek();
    }
}
