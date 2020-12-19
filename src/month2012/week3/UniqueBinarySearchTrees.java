package month2012.week3;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(5));
	}
	List<Integer> treeCount = new ArrayList<Integer>();
	public UniqueBinarySearchTrees() {
		treeCount.add(1);
		treeCount.add(1);
		treeCount.add(2);
	}
	
	/**
	 * <pre>
	 * 	숫자가 주어지고 그 숫자로 만들수있는 고유 트리 갯수 구하기 
	 * </pre> 
	 * runTime : 0ms
	 * memory : 35.7MB
	 * */
	public int numTrees(int n ) {
		int result = 0;
		if(treeCount.size() > n) {
			return treeCount.get(n);
		}
		n--;
		for(int i=0; i <= n; i++) {
			result += numTrees(i) * numTrees(n-i);
		}
		treeCount.add(result);
		return result;
	}
}
