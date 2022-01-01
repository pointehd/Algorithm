package year2021.programmers;

/**
 * Programmers. 콜라츠 추측 TODO
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 *
 * */
public class 콜라즈_추측 {

    public int solution(int num) {
        int result = 0;
        if (checkInputNum(num)){
            return -1;
        }
        long longNum = num;
        do{
            if (checkEvenNumber(longNum)) {
                longNum /= 2;
            } else {
                longNum =  3 * longNum + 1;
            }
        }while (longNum != 1 && ++result < 500);
        return result > 500 ? -1 : result;
    }

    public boolean checkEvenNumber(long num) {
        return num % 2 == 0;
    }

    public boolean checkInputNum(int num){
        return !(num > 1 && num < 8000000);
    }

    public static void main(String[] args) {
        System.out.println(new 콜라즈_추측().solution(626331));
    }
}
