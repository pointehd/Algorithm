package year2021.programmers;

public class NewId {
    public static void main(String[] args) {
        NewId n = new NewId();
        System.out.println(n.newId(".a."));

    }
    public String newId(String new_id){
//      대문자 -> 소문자로 치환
        String one = new_id.toLowerCase();

//      소문자 -_. 제외 문자 제거
        String two = one.replaceAll("[^\\w\\_\\.\\-]", "");

//      마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String three = two.replaceAll("\\.{2,}", ".");

//      마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String four = three.replaceAll("^\\.", "").replaceAll("\\.$", "");

        String five = four.length()>0 ? four : "a";

        String six = five.length()>15 ? five.substring(0,15).replaceAll("[\\.]$","") : five;

        if(six.length() <= 2){
            for(int i=0; i<=3-six.length(); i++){
                six += six.charAt(six.length()-1);
            }
        }
        return six;
    }
}
