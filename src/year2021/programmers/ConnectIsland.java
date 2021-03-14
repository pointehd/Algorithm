package year2021.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {
    int[] groupTable;

    public int find(int child) {
        if (groupTable[child] == child) {
            return child;
        } else {
            return groupTable[child] = find(groupTable[child]);
        }
    }
    /**
     * 테스트 1 〉	통과 (0.53ms, 52.1MB)
     * 테스트 2 〉	통과 (0.55ms, 53.8MB)
     * 테스트 3 〉	통과 (0.61ms, 52.7MB)
     * 테스트 4 〉	통과 (0.57ms, 52.2MB)
     * 테스트 5 〉	통과 (0.54ms, 52.5MB)
     * 테스트 6 〉	통과 (0.74ms, 52.7MB)
     * 테스트 7 〉	통과 (1.87ms, 53MB)
     * 테스트 8 〉	통과 (0.61ms, 53.9MB)
     * */
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[2];
                Integer b = o2[2];
                return a.compareTo(b);
            }
        });

        groupTable = new int[n];
        for (int i = 0; i < groupTable.length; i++) {
            groupTable[i] = i;
        }
        for (int[] cost : costs) {
            int firstIsland = find(cost[0]);
            int SecondIsland = find(cost[1]);
            if (firstIsland != SecondIsland) { //부모가 같지 않다면 연결이 안된 최솟값이므로
                groupTable[SecondIsland] = firstIsland;
                answer += cost[2];
            }
            // 뭐가 그리 다른건지 잘모르겠다..
//            if (groupTable[cost[0]] != groupTable[cost[1]]) {
//                answer += cost[2];
//                for (int i = 0; i < groupTable.length; i++) {
//                    if (groupTable[i] == cost[1])
//                        groupTable[i] = groupTable[cost[0]];
//                }
//            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(new ConnectIsland().solution(n, costs));
    }
}
