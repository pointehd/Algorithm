package month2009.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		Solution1 sol = new Solution1();
		sol.solution(progresses, speeds);

	}

	/*
	 *  테스트 1 〉	통과 (0.05ms, 69.4MB)
		테스트 2 〉	통과 (0.17ms, 69MB)
		테스트 3 〉	통과 (0.24ms, 71.4MB)
		테스트 4 〉	통과 (0.16ms, 69.8MB)
		테스트 5 〉	통과 (0.05ms, 69MB)
		테스트 6 〉	통과 (0.06ms, 70MB)
		테스트 7 〉	통과 (0.26ms, 69.8MB)
		테스트 8 〉	통과 (0.06ms, 69.2MB)
		테스트 9 〉	통과 (0.15ms, 69.5MB)
		테스트 10 〉	통과 (0.19ms, 69.3MB)
		테스트 11 〉	통과 (0.03ms, 70.3MB)
	 */
	// 옛날에 푼 문제.
	public int[] beforeSolution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int size = progresses.length - 1;
		int finish = 0;
		List<Integer> list = new ArrayList<Integer>();

		while (finish - 1 < size) {
			for (int i = 0; i <= size; i++) {
				progresses[i] += speeds[i];
			}
			int push = 0;
			for (int i = finish; i <= size; i++) {
				if (progresses[i] >= 100) {
					push++;
					finish = i + 1;
					if (finish == size + 1) {
						list.add(push);
					}
				} else {
					if (push != 0) {
						list.add(push);
					}
					break;
				}
			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	/*
	 *  테스트 1 〉	통과 (0.03ms, 70.7MB)
		테스트 2 〉	통과 (0.21ms, 68.9MB)
		테스트 3 〉	통과 (0.30ms, 69.3MB)
		테스트 4 〉	통과 (0.12ms, 68.9MB)
		테스트 5 〉	통과 (0.04ms, 69.3MB)
		테스트 6 〉	통과 (0.06ms, 70.6MB)
		테스트 7 〉	통과 (0.26ms, 68.4MB)
		테스트 8 〉	통과 (0.06ms, 69.2MB)
		테스트 9 〉	통과 (0.20ms, 69.6MB)
		테스트 10 〉	통과 (0.21ms, 70.4MB)
		테스트 11 〉	통과 (0.03ms, 69MB)
	 */
	// 20.09.07 푼 문제.
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> result = new ArrayList<Integer>();
		int startIndex = 0;
		while (startIndex < progresses.length) {

			boolean flag = true;
			int delete = 0;
			for (int i = startIndex; i < progresses.length; i++) {
				progresses[i] += speeds[i];

				if (flag && progresses[i] >= 100) {
					delete++;
				} else if (flag) {
					flag = false;
					if (delete > 0) {
						System.out.println(delete + "왜들어" + i);
						startIndex += delete;
						result.add(delete);
					}
				}
				if (flag && i == progresses.length - 1) {
					System.out.println(delete + "왜들어" + i);
					startIndex += delete;
					result.add(delete);
				}
			}

		}
		int[] resultArray = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}
}
