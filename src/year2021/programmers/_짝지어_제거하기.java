package year2021.programmers;

public class _짝지어_제거하기 {
    public int solution(String s) {
        StringBuffer sb = new StringBuffer(s);

        int index = 0;
        while (index+1 < sb.length()) {
            char tmp = sb.charAt(index);
            if (tmp == sb.charAt(index + 1)) {
                String tt = sb.toString();
                sb.delete(index, index + 2);
                index = index -1 < 0 ? 0 : index-1;
            }else {
                index++;
            }
        }
        return sb.length() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new _짝지어_제거하기().solution("bccbcc"));
    }
}
