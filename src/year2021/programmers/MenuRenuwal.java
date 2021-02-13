package year2021.programmers;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;



public class MenuRenuwal {
    // 코스 종류 Map<코스, 카운트>
    static Map<String, Integer> courseCount  = new HashMap<>();

    static int max = 1;

    /**
     * 1. 길이제한 코스(문자열) 확인
     * 2. 최대반복횟수가 높은 코스 확인하여 2 이상이면 추가
     * 3. (반복)
     * runTime, memory
     * 테스트 1 〉	통과 (19.90ms, 53.9MB)
     * 테스트 2 〉	통과 (21.80ms, 53.1MB)
     * 테스트 3 〉	통과 (20.04ms, 53.2MB)
     * 테스트 4 〉	통과 (21.07ms, 52.7MB)
     * 테스트 5 〉	통과 (20.90ms, 53.1MB)
     * 테스트 6 〉	통과 (23.28ms, 53.4MB)
     * 테스트 7 〉	통과 (31.09ms, 54.6MB)
     * 테스트 8 〉	통과 (66.15ms, 61.5MB)
     * 테스트 9 〉	통과 (51.54ms, 60.5MB)
     * 테스트 10 〉	통과 (47.16ms, 55.5MB)
     * 테스트 11 〉	통과 (39.64ms, 53.8MB)
     * 테스트 12 〉	통과 (38.79ms, 53.6MB)
     * 테스트 13 〉	통과 (40.81ms, 60.5MB)
     * 테스트 14 〉	통과 (53.47ms, 58.3MB)
     * 테스트 15 〉	통과 (59.05ms, 56.6MB)
     * 테스트 16 〉	통과 (38.74ms, 59.1MB)
     * 테스트 17 〉	통과 (40.67ms, 57.5MB)
     * 테스트 18 〉	통과 (51.80ms, 59.9MB)
     * 테스트 19 〉	통과 (32.98ms, 54.9MB)
     * 테스트 20 〉	통과 (46.57ms, 57.4MB)
     * */
    public String[] menuRenuwal(String[] orders, int[] course){
        Map<Integer, Integer> courseMax = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int count : course){
            for(String order : orders){
                find(0, "", count, 0, order);
            }
            if(max <2){
                continue;
            }
            for(String key :  courseCount.keySet()){
                if(key.length() == count && courseCount.get(key) == max){
                    result.add(key);
                }
            }
            max = 1;
        }

        Collections.sort(result);
        return result.stream().toArray(String[] :: new);
    }

    // dfs 문자열 탐색
    /**
     * dfs 문자열 탐색
     * @param cnt 현재 길이
     * @param str 시작문자
     * @param targetNum 길이
     * @param idx 현재 타겟 문자열
     * @param word 현재 문자
     * */
    static void find(int cnt,String str,int targetNum,int idx,String word){
        if (cnt==targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for (int i=0;i<c.length;i++)
                temps+=c[i];
            courseCount.put(temps,courseCount.getOrDefault(temps,0)+1);
            max = Math.max(max,courseCount.get(temps));
            return;
        }
        for (int i=idx;i<word.length();i++){
            char now =word.charAt(i);
            find(cnt+1,str+now,targetNum,i+1,word);
        }
    }
    // test
    /**
     *
     * */
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        new MenuRenuwal().menuRenuwal(orders, course);
    }
}
