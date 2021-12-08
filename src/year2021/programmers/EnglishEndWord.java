package year2021.programmers;

import java.util.HashSet;
import java.util.Set;

public class EnglishEndWord {

    /**
     * 테스트 1 〉	통과 (0.19ms, 77.1MB)
     * 테스트 2 〉	통과 (0.16ms, 74.2MB)
     * 테스트 3 〉	통과 (0.17ms, 72.4MB)
     * 테스트 4 〉	통과 (0.15ms, 67.1MB)
     * 테스트 5 〉	통과 (0.21ms, 68.6MB)
     * 테스트 6 〉	통과 (0.24ms, 75.4MB)
     * 테스트 7 〉	통과 (0.15ms, 74.3MB)
     * 테스트 8 〉	통과 (0.15ms, 84.4MB)
     * 테스트 9 〉	통과 (0.16ms, 78.6MB)
     * 테스트 10 〉	통과 (0.20ms, 77MB)
     * 테스트 11 〉	통과 (0.17ms, 76.7MB)
     * 테스트 12 〉	통과 (0.23ms, 82.5MB)
     * 테스트 13 〉	통과 (0.20ms, 68.3MB)
     * 테스트 14 〉	통과 (0.14ms, 72.4MB)
     * 테스트 15 〉	통과 (0.04ms, 75.7MB)
     * 테스트 16 〉	통과 (0.13ms, 72.8MB)
     * 테스트 17 〉	통과 (0.16ms, 76.6MB)
     * 테스트 18 〉	통과 (0.22ms, 75.9MB)
     * 테스트 19 〉	통과 (0.21ms, 74.6MB)
     * 테스트 20 〉	통과 (0.20ms, 73.9MB)
     * */
    public int[] solution(int n, String[] words) {
        int count =0;
        Set useWord = new HashSet<String>();
        char last =words[0].charAt(0);
        while(count < words.length) {
            char now = words[count].charAt(0);
            if(useWord.contains(words[count]) || now != last){
                count++;
                int front = count % (n) ;
                // TODO 여기 코드 수정 필요 ( 중복줄이기 )
                return new int[]{front == 0 ? n : front , count / n + (front == 0 ? 0 : 1)};
            }
            // TODO 여기 코드 수정 필요 ( 중복줄이기 )
            last = words[count].charAt(words[count].length()-1);
            useWord.add(words[count++]);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int [] result =new EnglishEndWord().solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        System.out.println(result[0] +" : "+ result[1]);
    }


}
