package year2021.leetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();


        return result;
    }

    public void candidatesTracking(int[] candidates, int index, int tempSize, int target, List<Integer> tmp){
        if (target == 0) {
            result.add(new ArrayList(tmp));
            return ;
        }
        for (int i=index; i<tmp.size(); i++) {

            if (candidates[i] <=  target) {
                tmp.add(candidates[i]);
                candidatesTracking(candidates, tempSize, tempSize+1, target-candidates[i], tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {

    }

}
