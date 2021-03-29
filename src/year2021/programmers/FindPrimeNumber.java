package year2021.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPrimeNumber {

    public static void main(String[] args) {
        String number = "011";
        System.out.println(new FindPrimeNumber().solution(number));
    }


    Set<Integer> primeSet = new HashSet<>();

    /**
     * TODO 다른사람 코드 한번 더 보기
     테스트 1 〉	통과 (5.89ms, 53.1MB)
     테스트 2 〉	통과 (51.72ms, 55.1MB)
     테스트 3 〉	통과 (7.76ms, 52.4MB)
     테스트 4 〉	통과 (42.90ms, 56MB)
     테스트 5 〉	통과 (38.48ms, 59.9MB)
     테스트 6 〉	통과 (5.23ms, 52.4MB)
     테스트 7 〉	통과 (6.12ms, 53MB)
     테스트 8 〉	통과 (34.49ms, 58.9MB)
     테스트 9 〉	통과 (9.17ms, 52MB)
     테스트 10 〉	통과 (162.60ms, 55.9MB)
     테스트 11 〉	통과 (22.60ms, 52.5MB)
     테스트 12 〉	통과 (8.04ms, 53MB)
     * */
    public int solution(String number){
        List<String> list = Arrays.stream(number.split("")).collect(Collectors.toList());
        boolean[] checkUse = new boolean[list.size()];
        IntStream.range(0, list.size()).forEach(i->{
            checkUse[i]= true;
            makePrimeNumber(list, list.get(i), checkUse);
            checkUse[i] = false;
        });
        return primeSet.size();
    }

    public void makePrimeNumber(List<String> list, String now, boolean[] checkUse){
        int number = Integer.parseInt(now);
        if(primeSet.contains(now)){
            return ;
        }
        boolean flag = number < 2  ? false : true;
        for(int i =2; i<number && flag; i++){
            if(number % i == 0){
                flag = false;
                break;
            }
        }
        if(flag){
            primeSet.add(number);
        }
        IntStream.range(0, checkUse.length).forEach(i->{
            if(!checkUse[i]){
                checkUse[i] = true;
                makePrimeNumber(list, now+list.get(i), checkUse);
                checkUse[i] = false;
            }
        });
    }
}
