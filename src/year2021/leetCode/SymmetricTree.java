package year2021.leetCode;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 *
 * RunTime: 1 ms
 * Memory: 39.4 MB
 * */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return matchSameTree(root, root);
    }

    public boolean matchSameTree(TreeNode r1, TreeNode r2) {
        if (r1==null && r2==null) {
            return true;
        }
        if (r1==null || r2== null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return matchSameTree(r1.left, r2.right) && matchSameTree(r1.right, r2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println(new SymmetricTree().isSymmetric(root));
    }

    public static class TreeNode {
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
