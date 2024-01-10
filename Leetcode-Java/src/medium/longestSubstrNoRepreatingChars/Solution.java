package medium.longestSubstrNoRepreatingChars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;

        int strLength = s.length();
        if(strLength == 1) return 1;

        int leftPointer = 0, rightPointer = 1, maxLength = 1;
        HashMap<Character, Integer> charsIndexes = new HashMap<>();
        while (rightPointer < strLength){
            charsIndexes.put(s.charAt(leftPointer), leftPointer);
            while (rightPointer < strLength && !charsIndexes.containsKey(s.charAt(rightPointer))){
                charsIndexes.put(s.charAt(rightPointer), rightPointer);
                rightPointer++;
            }

            maxLength = Math.max(maxLength, rightPointer - leftPointer);
            if(rightPointer == strLength) break;
            leftPointer = charsIndexes.get(s.charAt(rightPointer)) + 1;
            rightPointer = leftPointer + 1;
            charsIndexes.clear();
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("1234567890"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
