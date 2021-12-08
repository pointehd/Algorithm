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
    char[] orderVowels = {'A', 'E', 'I', 'O', 'U', ' '};
    public int solution(String word) {



        /**
         * A E I O U
         * A, AA, AAA, , ,
         * AAAA,
         * AAAAA, AAAAE, AAAAI, AAAAO, AAAAU (+5)
         * AAAE,
         * AAAEA, AAAEE, AAAEI, AAAEO, AAAEU (+5)
         * AAAI, ...
         * (+5)
         * AAAO
         * (+5)
         * AAAU
         * (+5)
         * AAE
         * */

        return answer;
    }

    public static void main(String[] args) {

    }

    public void makStr(StringBuffer str, String word) {
        if(str.length() < 5) {
            str.append(orderVowels[0]);
        }


        if(word.equals(str.toString())) return;
    }

}
