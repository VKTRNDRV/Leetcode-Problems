package medium.search2dMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0][0] > target || matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] < target){
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            int firstNum = matrix[mid][0];
            int lastNum = matrix[mid][matrix[mid].length - 1];
            if(firstNum == target || lastNum == target) return true;

            if(firstNum < target && target < lastNum){
                start = mid;
                break;
            }else{
                if(lastNum < target){
                    start = mid + 1;

                }else {
                    end = mid - 1;
                }
            }
        }

        int[] row = matrix[start];
        start = 0;
        end = row.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int num = row[mid];
            if(num == target ||
                    row[start] == target ||
                    row[end] == target) return true;

            if(num < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[] { 1, 3, 5, 7},
                new int[] {10,11,16,20},
                new int[] {23,30,34,50}
        }, 11));

        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[] { 1, 3, 5, 7},
                new int[] {10,11,16,20},
                new int[] {23,30,34,50}
        }, 10));

        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[] { 1, 3, 5, 7},
                new int[] {10,11,16,20},
                new int[] {23,30,34,60}
        }, 5));

        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1},
                new int[]{3}
        }, 3));

        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1,3}
        }, 3));

        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[] { 1, 3, 5, 7},
                new int[] {10,11,16,20},
                new int[] {23,30,34,60}
        }, 3));
    }
}
