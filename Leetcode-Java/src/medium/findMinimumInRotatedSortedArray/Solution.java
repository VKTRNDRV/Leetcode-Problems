package medium.findMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid, firstEl, lastEl, midEl;
        while (left < right){
            mid = (left + right) / 2;
            firstEl = nums[left];
            lastEl = nums[right];
            midEl = nums[mid];
            if(firstEl < lastEl){
                right = mid - 1;
                continue;
            }

            if(right - left == 1){
                return Math.min(firstEl, lastEl);
            }

            if(firstEl < midEl){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return nums[left];
    }
}
