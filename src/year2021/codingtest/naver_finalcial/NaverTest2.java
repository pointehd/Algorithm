package year2021.codingtest.naver_finalcial;

public class NaverTest2 {
    public static void main(String[] args) {
        NaverTest2 t2 = new NaverTest2();
        int[] A = {1,2,5,9,9};
        int X = 1;
        System.out.println(t2.solution(A, X));
    }
    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        System.out.println("HHHHHHHHH");

        while (l < r) {

            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                if(A[m] == X){
                    r = m;
                }
                l = r-1 == l ? m+1 : m;
                System.out.println("l : "+l);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        System.out.println("result L : R : " + l +","+r);
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
