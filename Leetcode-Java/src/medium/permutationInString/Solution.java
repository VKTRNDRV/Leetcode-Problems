package medium.permutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> requiredChars = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            if(!requiredChars.containsKey(currentChar)){
                requiredChars.put(currentChar, 1);
                continue;
            }

            requiredChars.put(currentChar,
                    requiredChars.get(currentChar) + 1);
        }

        // endIndex is exclusive
        int startIndex = 0, endIndex = startIndex + s1.length();
        for (int i = startIndex; i < endIndex; i++) {
            char currentChar = s2.charAt(i);
            if(!requiredChars.containsKey(currentChar)) continue;
            int countLeft = requiredChars.get(currentChar) - 1;
            requiredChars.put(currentChar, countLeft);
        }


        while (true){
            boolean areAllCharsFound = true;
            for(int value : requiredChars.values()){
                if(value > 0){
                    areAllCharsFound = false;
                    break;
                }
            }

            if(areAllCharsFound) return true;

            if(endIndex == s2.length()) break;

            char endIndexChar = s2.charAt(endIndex);
            if(requiredChars.containsKey(endIndexChar)){
                requiredChars.put(endIndexChar,
                        requiredChars.get(endIndexChar) - 1);
            }

            char startIndexChar = s2.charAt(startIndex);
            if(requiredChars.containsKey(startIndexChar)){
                requiredChars.put(startIndexChar,
                        requiredChars.get(startIndexChar) + 1);
            }

            startIndex++;
            endIndex++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("6453", "0123456789"));
        System.out.println(new Solution().checkInclusion("64531", "0123456789"));
    }
}
