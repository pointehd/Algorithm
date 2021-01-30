package year2021.leetCode;

import java.util.*;

/**
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * 문제설명 : 배열이 주어지고 k개의 가장 빈번한 숫자 찾기
 * */
public class TopKFrequentElements {
    /**
     * Runtime : 11ms
     * Memory Usage : 41.7MB
     * */
    public int[] topKFrequentElements(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> listEntries = new ArrayList<>(map.entrySet());

        Collections.sort(listEntries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 오름차순
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] result = new int[k];
        for(int i=0; i< k; i++){
            result[i] = listEntries.get(i).getKey();
        }
        return result;
    }
}
