package month2012.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInorder {
	
	
	
	
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		insertInorderIteratively(result, root);
		return result;
	}
	/**
	 * 반복문사용
	 * stack을 이용한 반복문사용 
	 * runTime :0ms
	 * memory : 37.2MB  
	 * */
	public void insertInorderIteratively(List<Integer> list, TreeNode root) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		while(root != null || !nodeStack.empty()) {
			while(root != null) {
				nodeStack.add(root);
				root = root.left;
			}
			TreeNode node = nodeStack.pop();
			list.add(node.val);
			root = node.right;
		}
	}
	
	/**
	 * 재귀 이용 
	 * runTime : 0 ms 
	 * memory : 37.5MB 
	 * */	
	public void insertInorderRecursive(List<Integer> list, TreeNode root) {
		if(root == null) {
			return ;
		}
		insertInorderRecursive(list, root.left);
		list.add(root.val);
		insertInorderRecursive(list, root.right);
	} // end insertInorderRecursive
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode () {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
