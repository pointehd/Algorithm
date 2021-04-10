package year2021.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TravelRoute {
    private static final String START_POINT = "ICN";

    boolean[] visited;
    List<String> answers;

    /**
     * 테스트 1 〉	통과 (110.33ms, 74.7MB)
     * 테스트 2 〉	통과 (14.26ms, 53.8MB)
     * 테스트 3 〉	통과 (13.35ms, 52.9MB)
     * 테스트 4 〉	통과 (13.41ms, 53.2MB)
     * */
    public String[] solution(String[][] tickets){
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();

        IntStream.range(0, tickets.length).forEach(i->{
            if(tickets[i][0].equals(START_POINT)){
                visited[i] = true;
                dfsTravel(tickets, tickets[i][1], new String(tickets[i][0]), 1);
                visited[i] = false;
            }
        });
//        answers.stream().forEach(System.out::println);
        Collections.sort(answers);
        answers.stream().forEach(System.out::println);
        return answers.get(0).split(",");
    }
    public void dfsTravel(String[][] tickets, String now, String dist, int count){
        dist = dist +","+now;
        if(count == visited.length){
            answers.add(dist.toString());
            return ;
        }
        for(int i =0;i< tickets.length; i++){
            if(tickets[i][0].equals(now) && !visited[i]){
                visited[i] = true;
                dfsTravel(tickets, tickets[i][1], dist, count+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        new TravelRoute().solution(tickets);
    }
}
