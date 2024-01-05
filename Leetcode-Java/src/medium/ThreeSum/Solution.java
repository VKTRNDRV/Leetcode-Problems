package medium.ThreeSum;

import javax.xml.crypto.dsig.XMLSignature;
import java.util.*;

class Solution {

//    public List<List<Integer>> threeSum(int[] nums) {
//        int numsCount = nums.length;
//        List<List<Integer>> solutions = new ArrayList<>();
//        HashMap<Integer, List<Integer>> numsIndexes = new HashMap<>();
//
//        //add numbers and indexes where they appear
//        for (int i = 0; i < numsCount; i++) {
//            int currentNum = nums[i];
//            if(!numsIndexes.containsKey(currentNum)){
//                List<Integer> indexes = new ArrayList<>();
//                indexes.add(i);
//                numsIndexes.put(currentNum, indexes);
//                continue;
//            }
//
//            numsIndexes.get(currentNum).add(i);
//        }
//
//        // check for matches
//        int firstNum, secondNum, requiredNum;
//        boolean isValid;
//        for (int firstIndex = 0; firstIndex < numsCount - 2; firstIndex++) {
//            firstNum = nums[firstIndex];
//            for (int secondIndex = firstIndex + 1; secondIndex < numsCount - 1; secondIndex++) {
//                secondNum = nums[secondIndex];
//                requiredNum = 0 - firstNum - secondNum;
//
//                // if required number is present in array
//                if(numsIndexes.containsKey(requiredNum)){
//                    isValid = false;
//                    List<Integer> indexes = numsIndexes.get(requiredNum);
//                    for(int index : indexes){
//                        if(index != firstIndex && index != secondIndex){
//                            isValid = true;
//                            break;
//                        }
//                    }
//                    if(!isValid) continue;
//
//                    List<Integer> candidates = new ArrayList<>();
//                    candidates.add(firstNum);
//                    candidates.add(secondNum);
//                    candidates.add(requiredNum);
//                    candidates.sort(Integer::compareTo);
//
//                    for(List<Integer> solution : solutions){
//                        if(Objects.equals(solution.get(0), candidates.get(0)) &&
//                                Objects.equals(solution.get(1), candidates.get(1)) &&
//                                Objects.equals(solution.get(2), candidates.get(2))){
//                            isValid = false;
//                            break;
//                        }
//                    }
//
//                    if(isValid){
//                        solutions.add(candidates);
//                    }
//                }
//            }
//        }
//
//        return solutions;
//    }
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
