package easy.validAnagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> firstString = parseChars(s);
        HashMap<Character, Integer> secondString = parseChars(t);
        if(firstString.keySet().size() != secondString.keySet().size()){
            return false;
        }

        for(Map.Entry<Character, Integer> charEntry : secondString.entrySet()){
            if(!firstString.containsKey(charEntry.getKey())){
                return false;
            }

            if(charEntry.getValue().compareTo(firstString.get(charEntry.getKey())) != 0){
                return false;
            }
        }
        return true;
    }

    public HashMap<Character, Integer> parseChars(String str){
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character currChar = str.charAt(i);
            if(!charCounts.containsKey(currChar)){
                charCounts.put(currChar, 1);
                continue;
            }
            charCounts.put(currChar, charCounts.get(currChar) + 1);
        }

        return charCounts;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().isAnagram("ab", "a"));
//    }
}
