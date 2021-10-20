package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.TreeNode;
import com.TreeUtils;


/**
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 * 
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * @author jeremypetit-jean
 *
 */
public class E993CousinsInBinaryTree {

	private static int xDepth = 0;
	private static int yDepth = 0;
	private static int xParent = 0;
	private static int yParent = 0;
	
	public static void dfs(TreeNode node, int depth, int x, int y, int parentValue) {
		if(node.val == x) {
			xDepth = depth;
			xParent = parentValue;
		}
		
		if(node.val == y) {
			yDepth = depth;
			yParent = parentValue;
		}
		
		// the two nodes has been found => return
		if(xDepth > 0 && yParent > 0) return;
		
		if(node.left != null) 
			dfs(node.left, depth + 1, x, y, node.val);
		if(node.right != null) 
			dfs(node.right, depth + 1, x, y, node.val);
	}
	
    public static boolean isCousins(TreeNode root, int x, int y) {
    	dfs(root, 0, x, y, root.val);
    	return xDepth == yDepth && xParent != yParent;
    }
	
	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 1,2,3,null,4,null,5 };
		int x = 5;
		int y = 4;
		TreeNode root = TreeUtils.fromArray(arr);
		System.out.println(isCousins(root, x, y)); 		
	}
}
