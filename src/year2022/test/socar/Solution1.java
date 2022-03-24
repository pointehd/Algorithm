package year2022.test.socar;

import java.util.*;

class Solution1 {
    int [][] graph;
    Set<Integer> positions = new HashSet<>();
    Map<Integer, Set<Integer>> checked = new HashMap<>();
    public int[] solution(int n, int k, int[][] roads) {
        graph = new int[n][n];
        for(int [] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        checkLastPosition(0, k);
        return positions.stream().mapToInt(x-> x).sorted().toArray();
    }
    private void checkLastPosition(int position, int k) {
        if(k == 0) {
            positions.add(position);
            return ;
        }
        if( k < 0) {
            return ;
        }
        int[] line = graph[position];
        for(int i =0; i< line.length; i++) {
            if(line[i] != 0 && (checked.get(i) == null || !checked.get(i).contains(k-line[i]))) {
                checked.computeIfAbsent(i, integer -> new HashSet<>()).add(k-line[i]);
                checkLastPosition(i, k-line[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        Arrays.stream(new Solution1().solution(6, 17, roads))
                .forEach(System.out::println);
    }
}
