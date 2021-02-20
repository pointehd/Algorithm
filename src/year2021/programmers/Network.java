package year2021.programmers;
/**
 * Programmers : 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * 테스트 1 〉	통과 (0.02ms, 53.1MB)
 * 테스트 2 〉	통과 (0.02ms, 52.1MB)
 * 테스트 3 〉	통과 (0.04ms, 52.3MB)
 * 테스트 4 〉	통과 (0.05ms, 52.1MB)
 * 테스트 5 〉	통과 (0.02ms, 51.9MB)
 * 테스트 6 〉	통과 (0.13ms, 53.1MB)
 * 테스트 7 〉	통과 (0.02ms, 52.7MB)
 * 테스트 8 〉	통과 (0.09ms, 52.5MB)
 * 테스트 9 〉	통과 (0.06ms, 52.1MB)
 * 테스트 10 〉	통과 (0.06ms, 53.1MB)
 * 테스트 11 〉	통과 (0.33ms, 52.1MB)
 * 테스트 12 〉	통과 (0.29ms, 52.4MB)
 * 테스트 13 〉	통과 (0.14ms, 52.2MB)
 * */
public class Network {
    public int network( int n, int[][] computers ){
        boolean[] netCheck = new boolean[n];
        int netCount = 0;
        for(int i=0; i<n; i++){
            if(!netCheck[i]){
                netCount++;
                networkBFS(computers, netCheck, i);
            }
        }
        return netCount;
    }
    public void networkBFS(int[][] computers, boolean[] netCheck, int check){
        if(netCheck[check])
            return ;
        netCheck[check] = true;
        for(int i=0; i< netCheck.length; i++){
            if(computers[check][i] == 1)
                networkBFS(computers, netCheck, i);
        }
    }


    // 실행 main
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        int n= 3;
        Network network = new Network();
        System.out.println(network.network(n, computers));
    }
}
