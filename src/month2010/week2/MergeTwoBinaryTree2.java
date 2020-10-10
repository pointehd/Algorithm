package month2010.week2;


public class MergeTwoBinaryTree2 {
	/**
	 * 실행시간 : 0 ms
	 * 메모리 : 39 MB
	 * */
	public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
			return t2;
		}
		mergeTwoTrees(t1, t2, null, true);
		return t1;
    }
	
	
	public void mergeTwoTrees(TreeNode t1, TreeNode t2, TreeNode t1Parent, boolean leftCheck) {
		if(t1 == null && t2 == null) {
			return ;
		} else if (t1 != null && t2 != null) {
			t1.val=t1.val+t2.val;
			mergeTwoTrees(t1.left, t2.left, t1, true);
			mergeTwoTrees(t1.right, t2.right, t1, false);
		} else if (t1 == null && t2 != null) {
			if(leftCheck) {
				t1Parent.left = t2;
			}else {
				t1Parent.right = t2;
			}
		} 
	}
	
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {}
		public TreeNode(int val) { this.val = val; }
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		/**
		 * equals 재정의 
		 * */
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			TreeNode tree = null;
			if( obj instanceof TreeNode) {
				tree = (TreeNode)obj;
			} else {
				return false;
			}
			try {
				preOderCompare(this, tree);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		
		public void preOderCompare(TreeNode node, TreeNode compare)  throws Exception{
			if(node!= null && compare != null && node.val != compare.val) {
				throw new Exception();
			}
			if(node == null && compare != null) {
				throw new Exception();
			}
			if(node != null) {
				preOderCompare(node.left, compare.left);
				preOderCompare(node.right, compare.right);
			}
		}
	}
	
	
	
}
