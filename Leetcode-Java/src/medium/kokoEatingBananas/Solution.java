package medium.kokoEatingBananas;

import java.util.Arrays;

public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles){
            right = Math.max(pile, right);
        }

        int mid, hoursSpent;
        while (left < right){
            mid = left + (right - left)/2;
            hoursSpent = 0;

            for(int pile : piles){
                hoursSpent += Math.ceil((double) pile / mid);
            }

            if(hoursSpent <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }
}
