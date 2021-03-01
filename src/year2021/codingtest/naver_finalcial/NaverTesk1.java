package year2021.codingtest.naver_finalcial;

public class NaverTesk1 {
    public String solution(String T){
        Double temp = Double.parseDouble(T);
        if(temp <= 35.0){
            return "hypothermia";
        } else if(temp <= 37.5){
            return "normal";
        } else if (temp <= 40){
            return "fever";
        } else {
            return "hyperpyrexia";
        }
    }
}
