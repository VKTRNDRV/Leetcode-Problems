package easy.binarySearch;

import java.lang.reflect.Array;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int numToCheck = nums[mid];

            if(numToCheck < target){
                start = mid + 1;
            }else if(numToCheck > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1}, 1));
        System.out.println(new Solution().search(new int[]{1,2}, 2));
        System.out.println(new Solution().search(new int[]{1,2,3}, 3));
        System.out.println(new Solution().search(new int[]{1,2,3,4}, 4));
        System.out.println(new Solution().search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(new Solution().search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(new Solution().search(new int[]{-1,0,5}, 5));
    }
}
