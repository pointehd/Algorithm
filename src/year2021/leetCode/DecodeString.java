package year2021.leetCode;


import java.util.Stack;
import java.util.regex.Pattern;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(s));
    }
    /**
     * runTime : 0ms
     * memory : 37.3MB
     *
     * 재귀를 이용한 풀이.. 진짜 대단한사람들
     * */
    private int i=0;
    public String decodeString2(String s){
        if (s == null || s.length() == 0) {
            return "";
        }
        int times = 0;
        StringBuilder sb = new StringBuilder();

        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                times = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                times = times * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    /**
     * Runtime : 8ms
     * Memory : 38.1MB
     *
     * 문자인지 숫자인지 비교하는 방법에대해 고민하다가 정규식으로도 판단해보려했는데 실패!
     * Exception 날리며 어떻게든 성공했지만 ㅠㅠ 아직 갈길이 멀다! 아자!
     * */
    public String decodeString(String s ){
        StringBuffer sb = new StringBuffer();
        String[] sArray = s.split("");
        Stack stack = new Stack();
        for(String one : sArray){
            try {
                int number = Integer.parseInt(one);
                stack.push(number);
            } catch (NumberFormatException e ){
                if("]".equals(one)){
                    StringBuffer tmp = new StringBuffer();
                    while(!"[".equals(stack.peek())){
                        tmp.insert(0, stack.pop());
                    }
                    stack.pop();
                    int count =0;
                    StringBuffer numberBuffer = new StringBuffer();
                    while(true){
                        try {
                            Integer.parseInt(String.valueOf(stack.peek()));
                            numberBuffer.insert(0, stack.pop());
                        }catch (Exception e2){
                            count = Integer.parseInt(numberBuffer.toString());
                            break;
                        }
                    }
                    StringBuffer tmp2 = new StringBuffer(tmp);
                    while(count != 1){
                        tmp2.append(tmp);
                        count --;
                    }
                    if(stack.isEmpty()){
                        sb.append(tmp2);
                    } else{
                        stack.push(tmp2);
                    }
                }else{
                    if(stack.isEmpty()){
                        sb.append(one);
                    }else{
                        stack.push(one);
                    }

                }
            }
        }
        return sb.toString();
    }
}
