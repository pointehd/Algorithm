package year2021.codingtest.naver_finalcial;

public class NaverTest3 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt((int)Math.pow(0, 2)+(int)Math.pow(2, 2)));

    }

    public int solution( int inner, int outer, int [] point_x, int[] points_y){
        int result = 0;
        for(int i=0; i<point_x.length; i++){
            double length = Math.sqrt((int)Math.pow(0, 2)+(int)Math.pow(2, 2));
            if(length > inner && length < outer)
                result++;
        }
        return result;
    }
}
