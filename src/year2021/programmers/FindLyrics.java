package year2021.programmers;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindLyrics {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.stream(new FindLyrics().solution(words, queries)).boxed()
                .map(i->i+"").collect(Collectors.joining(", ")));

    }

    public int[] solution(String[] words, String[] queries){
        return Arrays.stream(queries).mapToInt(q->{
//            String regix = "^"+q.replaceAll("\\?", "\\\\w{1}")+"$";
            String type = q.charAt(0) != '?' ? "prefix" : q.charAt(q.length()-1) != '?' ? "postfix":"all";
            return (int)Arrays.stream(words).filter(w->{
                if(w.length() != q.length()){
                    return false;
                }
                String regix = q.replaceAll("\\?", "");
                switch (type){
                    case "prefix":
                        return w.startsWith(regix);
                    case "postfix":
                        return w.endsWith(regix);
                    default:
                        return w.length() == q.length();
                }
            }).count();
        }).toArray();
    }
}
