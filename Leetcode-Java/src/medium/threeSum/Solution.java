package medium.threeSum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        LinkedList<List<Integer>> solutions = new LinkedList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the starting element 'i'
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                // Calculate the required sum for the two remaining elements
                int leftPointer = i + 1;
                int rightPointer = nums.length - 1;
                int required = 0 - nums[i];

                while (leftPointer < rightPointer) {
                    if (nums[leftPointer] + nums[rightPointer] == required) {
                        ArrayList<Integer> currentSolution = new ArrayList<>();
                        currentSolution.add(nums[i]);
                        currentSolution.add(nums[leftPointer]);
                        currentSolution.add(nums[rightPointer]);
                        solutions.add(currentSolution);

                        // Skip duplicates for the remaining elements
                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                            leftPointer++;
                        }
                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                            rightPointer--;
                        }

                        // Move the pointers towards each other for the next iteration
                        leftPointer++;
                        rightPointer--;
                    } else if (nums[leftPointer] + nums[rightPointer] < required) {
                        leftPointer++;
                    } else {
                        rightPointer--;
                    }
                }
            }
        }

        return solutions;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(new Solution().threeSum(new int[]{0,1,1}));
        System.out.println(new Solution().threeSum(new int[]{0,0,0}));
        System.out.println(new Solution().threeSum(new int[]{1,2,-2,-1}));
    }
}
