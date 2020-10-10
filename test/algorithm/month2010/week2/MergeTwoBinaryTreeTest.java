package algorithm.month2010.week2;

import static org.junit.Assert.*;

import org.junit.Test;

import month2010.week2.MergeTwoBinaryTree;
import month2010.week2.MergeTwoBinaryTree.TreeNode;


public class MergeTwoBinaryTreeTest {
	
	
	MergeTwoBinaryTree mtbt = new MergeTwoBinaryTree();

	@Test
	public void test() {
		TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2) );
		TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)) );
		
		TreeNode result = new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)) );
		assertEquals(mtbt.mergeTrees(t1, t2), result);
	}

}
