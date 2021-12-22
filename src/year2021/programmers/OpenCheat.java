package year2021.programmers;

import java.util.*;

/**
 * Programmers. 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 * 테스트 1 〉	통과 (4.26ms, 83.1MB)
 * 테스트 2 〉	통과 (2.77ms, 78.9MB)
 * 테스트 3 〉	통과 (3.15ms, 76MB)
 * 테스트 4 〉	통과 (3.11ms, 73.3MB)
 * 테스트 5 〉	통과 (6.46ms, 83.8MB)
 * 테스트 6 〉	통과 (6.57ms, 74.9MB)
 * 테스트 7 〉	통과 (6.32ms, 78.2MB)
 * 테스트 8 〉	통과 (8.47ms, 88MB)
 * 테스트 9 〉	통과 (6.88ms, 69.6MB)
 * 테스트 10 〉	통과 (5.48ms, 81.4MB)
 * 테스트 11 〉	통과 (4.93ms, 75.3MB)
 * 테스트 12 〉	통과 (5.01ms, 78.5MB)
 * 테스트 13 〉	통과 (5.70ms, 71MB)
 * 테스트 14 〉	통과 (6.21ms, 91.4MB)
 * 테스트 15 〉	통과 (2.75ms, 76.2MB)
 * 테스트 16 〉	통과 (2.58ms, 72.2MB)
 * 테스트 17 〉	통과 (3.17ms, 78.9MB)
 * 테스트 18 〉	통과 (3.19ms, 74.5MB)
 * 테스트 19 〉	통과 (5.96ms, 84.2MB)
 * 테스트 20 〉	통과 (5.70ms, 83.1MB)
 * 테스트 21 〉	통과 (5.24ms, 84.5MB)
 * 테스트 22 〉	통과 (5.28ms, 79.4MB)
 * 테스트 23 〉	통과 (5.76ms, 79MB)
 * 테스트 24 〉	통과 (6.15ms, 85MB)
 * 테스트 25 〉	통과 (93.44ms, 206MB)
 * 테스트 26 〉	통과 (102.89ms, 190MB)
 * 테스트 27 〉	통과 (105.68ms, 219MB)
 * 테스트 28 〉	통과 (105.12ms, 208MB)
 * 테스트 29 〉	통과 (128.52ms, 214MB)
 * 테스트 30 〉	통과 (85.89ms, 161MB)
 * 테스트 31 〉	통과 (121.11ms, 211MB)
 * 테스트 32 〉	통과 (104.09ms, 169MB)
 * */
public class OpenCheat {
    public String[] solution(String[] record) {
        Map<String, String> actMap = new HashMap<>();
        actMap.put("Enter", "님이 들어왔습니다.");
        actMap.put("Leave", "님이 나갔습니다.");
        actMap.put("Change", "님이 들어왔습니다.");

        Map<String, String> uidToNameMap  = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        for (String line : record) {
            String[] text = line.split(" ");
            if(text.length > 2){
                uidToNameMap.put(text[1], text[2]);
            }
            if("Change".equals(text[0])){
                continue;
            }
            List<String>  reco =  new ArrayList<>();
            reco.add(text[1]);
            reco.add(actMap.get(text[0]));
            results.add(reco);
        }
        return results.stream()
                .map(result -> uidToNameMap.get(result.get(0)) + result.get(1))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] record = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Arrays.stream(new OpenCheat().solution(record))
                .forEach(System.out::println);
    }

}
