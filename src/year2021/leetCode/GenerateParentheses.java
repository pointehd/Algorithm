package year2021.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode : 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/submissions/
 * */
public class GenerateParentheses {
    List<String> result;
    public List<String> generateParentheses(int n){
        result = new ArrayList<>();
        createParentheses("", 0, n, n*2, 0, 0);
        return result;
    }
    /**
     * @param message 시작메시지
     * @param count 현재 문자열길이
     * @param n 괄호 개수
     * @param max 최대 길이
     * @param openCount 현재 열린 괄호 개수
     * @param totalOpen 총 열림 개수
     * */
    public void createParentheses(String message, int count,int n, int max, int openCount, int totalOpen){
        if(max == count){
            result.add(message.toString());
            return ;
        }
        if (openCount == 0){
            createParentheses(message+"(", count+1, n, max, openCount+1, totalOpen+1);
        } else if (n== totalOpen){
            createParentheses(message+")", count+1, n, max, openCount-1, totalOpen);
        } else{
            createParentheses(message+"(", count+1, n, max, openCount+1, totalOpen+1);
            createParentheses(message+")", count+1, n, max, openCount-1, totalOpen);
        }
    }

    // 실행 test
    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParentheses(3);
        System.out.println(result.size());
        for (String text : result){
            System.out.println(text);
        }
    }
}
