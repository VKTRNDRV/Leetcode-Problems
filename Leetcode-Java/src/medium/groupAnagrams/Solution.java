package medium.groupAnagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedChars = Arrays.toString(word);

            if(anagrams.containsKey(sortedChars)){
                anagrams.get(sortedChars).add(strs[i]);
            }else{
                List<String> anagramList = new ArrayList<>();
                anagramList.add(strs[i]);
                anagrams.put(sortedChars, anagramList);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for(Map.Entry<String, List<String>> anagramGroup : anagrams.entrySet()){
            output.add(anagramGroup.getValue());
        }

        return output;
    }
}
