package easy.twoSum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexes.containsKey(nums[i])){
                if(nums[i] * 2 == target){
                    int[] result = new int[2];
                    result[0] = valueIndexes.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }else{
                valueIndexes.put(nums[i], i);
            }
        }

        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {

            for(int j = 0; j < i; j++){
                if(nums[i] + nums[j] == target){
                    int[] result = new int[2];
                    result[0] = valueIndexes.get(nums[i]);
                    result[1] = valueIndexes.get(nums[j]);
                    return result;
                }
            }
        }

        throw new IllegalArgumentException("No matches");
    }
}
