package year2021.programmers.weekly;

/**
 * Programmers. 상호평가 (weekly 8월 2주차)
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 *
 * RunTime, Memory : main() 참고
 * */
class _8_2상호평가 {

    public String solution(int[][] scores) {
        StringBuffer sb = new StringBuffer();
        int count = scores.length;

        for (int i=0; i<count; i++) {
            int sum = 0;
            int myScore = scores[i][i];
            int min = 101, max = -1;
            for (int j=0; j<count; j++) {
                if(j == i) {
                    continue;
                }
                min = Math.min(min, scores[j][i]);
                max = Math.max(max, scores[j][i]);
                sum += scores[j][i];
            }
            if(min == myScore
                || max == myScore
                || (min < myScore && max > myScore) ) {
                findGrade(sb, (sum+myScore)/count );
            } else {
                findGrade(sb, sum/(count-1));
            }
        }
        return sb.toString();
    }

    // 학점 구하기
    public void findGrade(StringBuffer sb, double avg){
        if (avg >= 90) {
            sb.append("A");
        } else if (avg >= 80) {
            sb.append("B");
        } else if (avg >= 70) {
            sb.append("C");
        } else if (avg >= 50) {
            sb.append("D");
        } else {
            sb.append("F");
        }
    }

    /**
     * 테스트 1 〉	통과 (0.08ms, 60.3MB)
     * 테스트 2 〉	통과 (0.08ms, 74MB)
     * 테스트 3 〉	통과 (0.13ms, 74.6MB)
     * 테스트 4 〉	통과 (0.12ms, 73.8MB)
     * 테스트 5 〉	통과 (0.10ms, 72.3MB)
     * 테스트 6 〉	통과 (0.07ms, 69.7MB)
     * 테스트 7 〉	통과 (0.09ms, 66.6MB)
     * 테스트 8 〉	통과 (0.10ms, 69.4MB)
     * 테스트 9 〉	통과 (0.09ms, 58MB)
     * 테스트 10 〉	통과 (0.10ms, 74MB)
     * 테스트 11 〉	통과 (0.13ms, 75.2MB)
     * 테스트 12 〉	통과 (0.09ms, 60.2MB)
     * 테스트 13 〉	통과 (0.09ms, 58.7MB)
     * 테스트 14 〉	통과 (0.13ms, 58.6MB)
     * 테스트 15 〉	통과 (0.08ms, 70MB)
     * 테스트 16 〉	통과 (0.09ms, 67.8MB)
     * 테스트 17 〉	통과 (0.13ms, 71.1MB)
     * 테스트 18 〉	통과 (0.09ms, 59.3MB)
     * 테스트 19 〉	통과 (0.08ms, 70.6MB)
     * 테스트 20 〉	통과 (0.10ms, 74.8MB)
     * 테스트 21 〉	통과 (0.09ms, 68.7MB)
     * */
    public static void main(String[] args) {
        int[][] scores = {
                {100,90,98,88,65},
                {50,45,99,85,77},
                {47,88,95,80,67},
                {61,57,100,80,65},
                {24,90,94,75,65}
        };
        System.out.println(new _8_2상호평가().solution(scores));
    }
}
