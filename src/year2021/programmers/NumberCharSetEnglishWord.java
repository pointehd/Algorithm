package year2021.programmers;

/**
 * Programmers. 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 *
 * 테스트 1 〉	통과 (0.30ms, 68.3MB)
 * 테스트 2 〉	통과 (0.29ms, 71.5MB)
 * 테스트 3 〉	통과 (0.30ms, 73.3MB)
 * 테스트 4 〉	통과 (0.33ms, 73.3MB)
 * 테스트 5 〉	통과 (0.36ms, 77.4MB)
 * 테스트 6 〉	통과 (0.32ms, 74.6MB)
 * 테스트 7 〉	통과 (0.33ms, 73.1MB)
 * 테스트 8 〉	통과 (0.36ms, 76.6MB)
 * 테스트 9 〉	통과 (0.35ms, 76.6MB)
 * 테스트 10 〉	통과 (0.30ms, 73.5MB)
 * */
public class NumberCharSetEnglishWord {
    String[] numberWords = {
            "zero", "one", "two", "three",
            "four", "five", "six", "seven",
            "eight", "nine"};

    public int solution(String s) {
        for(int i=0; i< numberWords.length; i++) {
            s = s.replaceAll(numberWords[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(new NumberCharSetEnglishWord().solution("one4seveneight"));
    }
}
