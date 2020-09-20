package month2009.week3;

public class MaximumDepthOfBinaryTree {
	
	/**
	 * RunTime : 0 ms
	 * Memory : 39.5 MB
	 * 
	 * @date 2020. 09. 20
	 * */
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if (root.left != null && root.right !=null) {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) +1; 
		} else if (root.left == null && root.right != null) {
			return maxDepth(root.right) +1;
		} else if (root.left != null && root.right == null) {
			return maxDepth(root.left)+1; 
		} else {
			return 1;
		}
		
    }
	
	/**
	 * RunTime : 0 ms
	 * Memory : 39.5 MB
	 * 
	 * @date 2020. 09. 01
	 * */
	public int nodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else{
            return 1 + Math.max(nodeCount(root.left), nodeCount(root.right));
        }                           
    }
	
	
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
