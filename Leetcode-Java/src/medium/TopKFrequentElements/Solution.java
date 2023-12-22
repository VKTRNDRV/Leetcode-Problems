package medium.TopKFrequentElements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1){
            return new int[]{nums[0]};
        }
        Arrays.sort(nums);
        List<List<Integer>> frequencies = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int occurancesCount = 1;
            for(int t = i + 1; t < nums.length; t++){
                int secondNum = nums[t];
                if(firstNum == secondNum){
                    occurancesCount++;
                    i++;
                }else{
                    break;
                }
            }

            boolean addedOrSkipped = false;
            for (int j = 0; j < frequencies.size(); j++) {
                if(j == k){
                    addedOrSkipped = true;
                    break;
                }
                if(frequencies.get(j).get(1) < occurancesCount){
                    frequencies.add(j, List.of(firstNum, occurancesCount));
                    addedOrSkipped = true;
                    break;
                }
            }

            if(!addedOrSkipped){
                frequencies.add(List.of(firstNum, occurancesCount));
            }
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = frequencies
                    .get(i)
                    .get(0);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 2, 2, 1};
//        System.out.println(Arrays.toString(new Solution().topKFrequent(input, 3)));
        input = new int[]{1,2};
        System.out.println(Arrays.toString(new Solution().topKFrequent(input, 2)));
    }
}
