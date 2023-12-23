package easy.validPalindrome;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        int firstIndex = 0;
        int secondIndex = s.length() - 1;
        while(firstIndex < secondIndex){
            char firstChar = s.charAt(firstIndex);
            char secondChar = s.charAt(secondIndex);

            if(!Character.isLetterOrDigit(firstChar)){
                firstIndex++;
                continue;
            }

            if(!Character.isLetterOrDigit(secondChar)){
                secondIndex--;
                continue;
            }

            if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
                return false;
            }

            firstIndex++;
            secondIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("race a car"));
    }
}
