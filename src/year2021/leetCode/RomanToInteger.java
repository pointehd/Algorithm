package year2021.leetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Roman 초기화 (final?? 괜찮을까?)
    private static final Map<Character, Integer> ROMAN_TO_INT= new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * LeetCode 13. Roman to Integer
     * https://leetcode.com/problems/roman-to-integer/
     *
     * RunTime: 5 ms
     * Memory: 39 MB
     * */
    public int romanToInt(String s){
        int result = 0;
        Character before = null;
        for(char roman : s.toCharArray()){
            // 이전 숫자보다 커질때 (ex. IV -> 4) 이전 문자를 2번 빼줌.
            if (before != null && ROMAN_TO_INT.get(before) < ROMAN_TO_INT.get(roman)) {
                result -= ROMAN_TO_INT.get(before) * 2;
            }
            before = roman;
            result += ROMAN_TO_INT.get(roman);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("VI"));
        System.out.println(new RomanToInteger().romanToInt("IV"));
    }
}
