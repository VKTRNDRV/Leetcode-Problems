package medium.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allAnswers = new ArrayList<>();
        checkFromIndex(0, candidates, target, allAnswers, new ArrayList<>());
        return allAnswers;
    }

    private void checkFromIndex(int index, int[] candidates, int target, List<List<Integer>> allAnswers, List<Integer> current) {

        if(target == 0){
            allAnswers.add(new ArrayList<>(current));
        }else if(target < 0 || index >= candidates.length){
            return;
        }else{
            current.add(candidates[index]);
            checkFromIndex(index, candidates, target - candidates[index], allAnswers, current);

            current.remove(current.size() - 1);
            checkFromIndex(index + 1, candidates, target, allAnswers, current);
        }
    }

    public static void main(String[] args) {
        for(List<Integer> list : new Solution()
                .combinationSum(new int[]{4,2,1}, 12)){

            System.out.println(list);
        }
    }
}
