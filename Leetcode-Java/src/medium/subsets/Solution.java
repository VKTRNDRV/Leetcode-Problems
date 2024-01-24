package medium.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        iterateFromIndex(allSubsets, 0, nums, new ArrayList<>());
        return allSubsets;
    }

    public void iterateFromIndex(List<List<Integer>> allSubsets, int index, int[] nums, List<Integer> subset){
        if (index < nums.length) {
            subset.add(nums[index]);
            iterateFromIndex(allSubsets, index + 1, nums, subset);

            subset.remove(subset.size() - 1);
            iterateFromIndex(allSubsets, index + 1, nums, subset);

        } else {
            allSubsets.add(new ArrayList<>(subset));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(
                new int[]{0,1,2}));
    }
}
