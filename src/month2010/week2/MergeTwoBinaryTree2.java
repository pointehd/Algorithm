package month2010.week2;


public class MergeTwoBinaryTree2 {
	/**
	 * 실행시간 : 0 ms
	 * 메모리 : 39 MB
	 * */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
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
