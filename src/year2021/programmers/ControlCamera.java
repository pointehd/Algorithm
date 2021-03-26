package year2021.programmers;

import java.util.Arrays;

public class ControlCamera {
	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(new ControlCamera().solution(routes));
	}
	
	/**
	 * 
	 * 정확성
		테스트 1 〉	통과 (0.72ms, 54MB)
		테스트 2 〉	통과 (0.88ms, 52.4MB)
		테스트 3 〉	통과 (0.85ms, 54MB)
		테스트 4 〉	통과 (0.84ms, 52.7MB)
		테스트 5 〉	통과 (0.92ms, 52.2MB)
		
	 * 효율성
		테스트 1 〉	통과 (6.20ms, 54MB)
		테스트 2 〉	통과 (3.46ms, 52.6MB)
		테스트 3 〉	통과 (7.51ms, 53.6MB)
		테스트 4 〉	통과 (1.09ms, 51.7MB)
		테스트 5 〉	통과 (8.38ms, 53.9MB)
		
	 * 느낀점	
		진짜 천재들이 많구나.. 어떻게 이런생각을 ㅎㅎ 아자!
	 * */
	public int solution(int[][] routes) {
		
//		Arrays.sort(routes, (r,g)-> r[0]>g[0] ? 1 : -1); 비슷한 뜻.
		Arrays.sort(routes, (r,g)-> Integer.compare(r[0], r[0]));
		
//		Arrays.stream(routes).forEach(e->{
//			System.out.println(e[0] +","+e[1]);
//		});
		int minOut = -30001;
		int result =0;
		
		for(int[] route : routes) {
			if(minOut < route[0]) {
				minOut = route[1];
				result ++;
			}
			minOut = Math.min(minOut, route[1]);
		}
		
		return result;
	}
}
