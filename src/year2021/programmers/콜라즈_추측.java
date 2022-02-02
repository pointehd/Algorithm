package year2021.programmers;

/**
 * Programmers. 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 */
public class 콜라즈_추측 {

    public int solution(int num) {
        int result = 0;
        long longNum = num;
        while (longNum != 1 && ++result < 500) {
            if (checkEvenNumber(longNum)) {
                longNum /= 2;
            } else {
                longNum = 3 * longNum + 1;
            }
        }
        return result >= 500 ? -1 : result;
    }

    public boolean checkEvenNumber(long num) {
        return num % 2 == 0;
    }


    public static void main(String[] args) {
        System.out.println(new 콜라즈_추측().solution(1));
    }
}
