package month2009.day01;

public class Solution01 {
	
	public int max;
    public int diameterOfBinaryTree(TreeNode root) {
        preOrder(root);
        return max;
    }
    
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
    public int getLength(TreeNode root){
        if(root == null){
            return 0;
        }
        return nodeCount(root.left) + nodeCount(root.right);
    }                     
    
    public void preOrder(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left != null)
            preOrder(root.left);
        if(root.right != null)
            preOrder(root.right);
        
        int num = getLength(root);
        if(max < num){
            max = num;
        }
    }
    static public class TreeNode {
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
