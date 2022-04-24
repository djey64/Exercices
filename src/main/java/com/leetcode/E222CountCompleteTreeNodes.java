package com.leetcode;

import com.TreeNode;
import com.TreeUtils;

public class E222CountCompleteTreeNodes {

	public static int leftDepth(TreeNode node) {
		if(node.left == null) return 0;
		return 1 + leftDepth(node.left);
	}
	
//    public int countNodes(TreeNode root) {
//        // Compute left depth of tree
//    	// right DFS
//    	// If right depth == left depth => full binary tree, number of nodes is 2^(k + 1) - 1
//    	// Else, need to find number of missing leaves, then number of nodes is 2^(k + 1) - 1 - missingLeaves    	
//    }
//    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] { 1,2,3,4,5,6 };
		TreeNode root = TreeUtils.fromArray(arr);
		System.out.println(leftDepth(root));
	}

}
