package medium.productOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int leftProduct = 1;
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct *= nums[i - 1];
            output[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            rightProduct *= nums[i + 1];
            output[i] = output[i] * rightProduct;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
