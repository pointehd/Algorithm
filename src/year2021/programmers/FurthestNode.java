package year2021.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class FurthestNode {
	public static void main(String[] args) {
		int n = 7;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2},{6,7}};
		System.out.println(new FurthestNode().solution(n, edge));
	}
	/**
	 * 	
		테스트 1 〉	통과 (7.38ms, 52.3MB)
		테스트 2 〉	통과 (5.95ms, 53.3MB)
		테스트 3 〉	통과 (3.77ms, 52.7MB)
		테스트 4 〉	통과 (4.30ms, 52.2MB)
		테스트 5 〉	통과 (13.10ms, 54.4MB)
		테스트 6 〉	통과 (25.15ms, 58.7MB)
		테스트 7 〉	통과 (400.12ms, 249MB)
		테스트 8 〉	통과 (1038.15ms, 557MB)
		테스트 9 〉	통과 (1150.52ms, 552MB)
		
		stream api 공부 및 람다식 공부  ing
		
	 * */
	public int solution(int n, int[][] edge) {
		boolean[][] map = new boolean[n+1][n+1];
		int[] dists = new int[n+1];
		int maxDist = 0;
		
		Arrays.stream(edge).forEach(e->{
			map[e[0]][e[1]] = map[e[1]][e[0]] =  true;
		});
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int i=1; i< n+1; i++) {
				if(map[node][i] && dists[i] == 0) {
					dists[i] = dists[node] +1;
					queue.add(i);
					maxDist = dists[node] +1;
				}
			}
		}
		
//		Arrays.stream(dists).forEach(System.out::println);
//		System.out.println(Arrays.stream(dists).boxed().map(e->e+"").collect(Collectors.joining(", ")));
		final int max = maxDist;
		return (int)IntStream.range(2, dists.length).filter(i->{
				return dists[i] == max ;
			}).count();
	}
}
