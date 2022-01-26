package year2021.programmers;

import java.util.*;

public class _신고_결과_받기 {

    /**
     * Programmers. 신고 결과 받기
     * https://programmers.co.kr/learn/courses/30/lessons/92334
     *
     * 내가 신고한사람이 신고됬는지 확인
     *
     * 테스트 1 〉	통과 (0.20ms, 78.3MB)
     * 테스트 2 〉	통과 (0.33ms, 77.3MB)
     * 테스트 3 〉	통과 (1993.83ms, 180MB)
     * 테스트 4 〉	통과 (0.33ms, 75.6MB)
     * 테스트 5 〉	통과 (0.29ms, 67.7MB)
     * 테스트 6 〉	통과 (16.35ms, 77.5MB)
     * 테스트 7 〉	통과 (19.75ms, 78.3MB)
     * 테스트 8 〉	통과 (18.45ms, 102MB)
     * 테스트 9 〉	통과 (246.41ms, 141MB)
     * 테스트 10 〉	통과 (3997.17ms, 147MB)
     * 테스트 11 〉	실패 (시간 초과)
     * 테스트 12 〉	통과 (3.84ms, 88.8MB)
     * 테스트 13 〉	통과 (4.91ms, 77.4MB)
     * 테스트 14 〉	통과 (749.37ms, 131MB)
     * 테스트 15 〉	통과 (7348.11ms, 153MB)
     * 테스트 16 〉	통과 (1.65ms, 87.9MB)
     * 테스트 17 〉	통과 (7.16ms, 78.2MB)
     * 테스트 18 〉	통과 (10.47ms, 78.7MB)
     * 테스트 19 〉	통과 (21.54ms, 86.1MB)
     * 테스트 20 〉	통과 (1331.16ms, 129MB)
     * 테스트 21 〉	통과 (257.76ms, 169MB)
     * */
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Set<String>> reportMap = new HashMap<>();
        for(String re : report) {
            String[] r = re.split(" ");
            Set<String> tempReport = reportMap.getOrDefault(r[0], new HashSet<>());
            tempReport.add(r[1]);
            reportMap.put(r[0], tempReport);
        }

        int[] result = new int[id_list.length];
        Set<String> reported = new HashSet<>();
        for(int i =0; i<id_list.length; i++) {
            Set<String> reportReset = reportMap.get(id_list[i]);

            if(reportReset == null) {
                continue;
            }
            for (String key : reportReset){
                if(reported.contains(key)){
                    result[i]++;
                    continue;
                }
                int count = 0;
                for(String reportUserName : reportMap.keySet()) {
                    if(reportMap.get(reportUserName).contains(key)) {
                        count ++;
                    }
                }
                if( count >= k){
                    reported.add(key);
                    result[i] ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(new _신고_결과_받기().solution(new String[]{"muzi", "frodo", "apeach", "neo" },
                new String[]{"muzi frodo", "apeach frodo","apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2))
                .forEach(System.out::println);
    }


}
