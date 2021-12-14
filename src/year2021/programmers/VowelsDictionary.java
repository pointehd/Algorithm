package year2021.programmers;

/**
 * Programmers. 모음 사전
 * type : 재귀
 * https://programmers.co.kr/learn/courses/30/lessons/84512?language=java
 *
 *
 *
 * 깨알 영어 공부
 * vowels : 모음
 * consonents : 자음
 *
 * */
public class VowelsDictionary {
    int answer = 0;
    String matchWord;
    boolean findFlag = false;

    public int solution(String word) {
        this.matchWord = word;
        recursiveMakeWord("");
        return answer;
    }

    private void recursiveMakeWord(String now) {
        if (this.findFlag || now.equals(this.matchWord)) {
            this.findFlag = true;
            return ;
        }
        this.answer++;
        if (now.length() == 5) {
            return ;
        }
        recursiveMakeWord(now+'A');
        recursiveMakeWord(now+'E');
        recursiveMakeWord(now+'I');
        recursiveMakeWord(now+'O');
        recursiveMakeWord(now+'U');
    }

    public static void main(String[] args) {
        System.out.println(new VowelsDictionary().solution("I"));
    }
}
