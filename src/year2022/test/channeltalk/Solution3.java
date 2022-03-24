package year2022.test.channeltalk;

/**
 *
 * 테스트 1 〉 통과 (0.60ms, 73.1MB)
 * 테스트 2 〉 통과 (1.23ms, 78.9MB)
 * 테스트 3 〉 통과 (2.15ms, 73.8MB)
 * 테스트 4 〉 실패 (4.10ms, 72MB)
 * 테스트 5 〉 통과 (11.93ms, 87.3MB)
 * 테스트 6 〉 통과 (24.47ms, 73.2MB)
 * 테스트 7 〉 통과 (69.30ms, 96.7MB)
 * 테스트 8 〉 통과 (122.34ms, 128MB)
 * 테스트 9 〉 통과 (212.36ms, 128MB)
 * 테스트 10 〉 통과 (286.19ms, 163MB)
 * 테스트 11 〉 통과 (8.15ms, 77.5MB)
 * 테스트 12 〉 통과 (13.09ms, 75.5MB)
 * 테스트 13 〉 통과 (7.56ms, 83.5MB)
 * 테스트 14 〉 통과 (3.61ms, 73.7MB)
 * 테스트 15 〉 통과 (0.08ms, 73.5MB)
 * 효율성 테스트
 * 테스트 1 〉 통과 (291.24ms, 170MB)
 * 테스트 2 〉 통과 (301.89ms, 184MB)
 * 테스트 3 〉 통과 (289.02ms, 195MB)
 * 테스트 4 〉 통과 (347.43ms, 215MB)
 * 테스트 5 〉 통과 (337.91ms, 208MB)
 * 테스트 6 〉 통과 (325.02ms, 225MB)
 * 테스트 7 〉 통과 (337.50ms, 234MB)
 * 테스트 8 〉 통과 (347.27ms, 242MB)
 * 테스트 9 〉 실패 (347.22ms, 243MB)
 * 테스트 10 〉 실패 (348.56ms, 255MB)
 * */
class Solution3 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 1; i <= 5; i++) {
            answer = Math.max(sequenceLengthByCount(i, s), answer);
        }
        return answer;
    }

    public int sequenceLengthByCount(int count, String s) {
        int result = 0;
        int tempCount = count;
        for (int i = 0; i < count && count+i < s.length() ; i++) {
            int tempResult = 0;
            int before = Integer.parseInt(s.substring(i, count+i));
            for(int j = i + count; j<= s.length()-tempCount; j+=tempCount) {
                int now = 0;
                if (before != -1 && Integer.toString(before).length() != Integer.toString(before+1).length()) {
                    if(Integer.toString(before+1).length() > 5) {
                        now = -1;
                    }else {
                        tempCount += 1;
                    }
                }

                String nowStr = s.substring(j, j + tempCount);
                if(nowStr.startsWith("0")){
                    now = -1;
                } else {
                    now = Integer.parseInt(nowStr);
                }
                System.out.println(before+":"+now);
                if(now == before +1) {
                    if(tempResult == 0) tempResult += count;
                    tempResult += tempCount;
                    System.out.println(before+":"+ now+" ("+ tempCount);
                } else {
                    result = Math.max(tempResult, result);
                    tempCount = count;
                    tempResult = 0;
                }
                before = now;
            }
            result = Math.max(tempResult, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().solution("123451234678910111213"));
    }
}
