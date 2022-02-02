package year2021.programmers;
/**
 * Programmers. 약수의 개수와 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/77884
 * */
class _약수의_개수와_덧셈 {

    public int solution(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++) {
            if( getMeasure(i) % 2 == 0){
                System.out.println("plus" + i);
                result +=i;
            }else {
                System.out.println("minus" + i);
                result -=i;
            }
        }
        return result;
    }

    private int getMeasure(int n) {
        if(n == 1) {
            return 1;
        }
        int result = 2;
        for(int i =2; i< n; i++) {
            if(n%i == 0){
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _약수의_개수와_덧셈().solution(13,17));

    }
}
