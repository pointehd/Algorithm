package year2021.leetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/submissions/
 *
 * RunTime:3 ms
 * Memory: 41.6 MB
 * */
public class CombinationSum {
    List<List<Integer>> result = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        for (int i=0; i<candidates.length; i++){
            List<Integer> tmp = new ArrayList();
            tmp.add(candidates[i]);
            candidatesTracking(candidates, i, 1, target-candidates[i], tmp);
        }
        return result;
    }

    public void candidatesTracking(int[] candidates, int index, int tmpSize, int target, List<Integer> tmp){
        if (target == 0) {
            result.add(new ArrayList(tmp));
            return ;
        }
        for (int i=index; i<candidates.length; i++) {
            if (candidates[i] <=  target) {
                tmp.add(candidates[i]);
                candidatesTracking(candidates, i, tmpSize+1, target-candidates[i], tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3, 5};
        int target = 8;
        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
        System.out.println(result.size());
        result.stream().forEach(System.out::println);
    }

}
