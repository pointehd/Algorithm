package year2021.leetCode;

import java.util.HashMap;
import java.util.Map;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        p.palidromicSubstrings("aba");
    }

    /**
     * runtime : 16ms
     * memory : 40.8MB
     *
     * 느낀점 : dp 너무 어렵고 진짜 천재인것같다! 
     * */
    public int palidromicSubstrings(String s){
        boolean[][] check = new boolean[s.length()][s.length()];
        int count = 0;
        for( int i = s.length()-1; i >= 0; i--){
            for( int j =i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)
                    && (j-i<2 || check[i+1][j-1] )){
                    check[i][j] = true;
                    count ++ ;
                }
            }
        }
        return count;
    }
}
