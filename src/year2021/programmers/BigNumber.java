package year2021.programmers;
import java.util.List;
import java.util.ArrayList;
public class BigNumber {
    /**
     * 테스트 1 〉	통과 (1900.09ms, 358MB)
     * 테스트 2 〉	통과 (690.24ms, 354MB)
     * 테스트 3 〉	통과 (2961.40ms, 362MB)
     * 테스트 4 〉	통과 (31.76ms, 61.2MB)
     * 테스트 5 〉	통과 (1533.85ms, 357MB)
     * 테스트 6 〉	통과 (1212.22ms, 356MB)
     * 테스트 7 〉	통과 (7.98ms, 52.3MB)
     * 테스트 8 〉	통과 (2.04ms, 52.1MB)
     * 테스트 9 〉	통과 (4.43ms, 52.3MB)
     * 테스트 10 〉	통과 (2.72ms, 53.2MB)
     * 테스트 11 〉	통과 (2.49ms, 52.2MB)
     * */
    public String bigNumber(int[] numbers){
        String answer = "";
        List <String> strings = new ArrayList<>();

        for(int num : numbers){
            strings.add(String.valueOf(num));
        }
        strings.sort(((o1,o2)->(o2 + o1).compareTo(o1 + o2)));
        for(String s:strings){
            answer += s;
        }
        // 0인경우
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
