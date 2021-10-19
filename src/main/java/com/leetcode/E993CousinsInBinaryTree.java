package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
		
		List<Integer> values = new ArrayList<>(Arrays.asList(arr));
		List<TreeNode> list = new ArrayList<>();
		TreeNode root = new TreeNode(values.remove(0));
		list.add(root);
		populateTree(list, values);
		
		System.out.println(isCousins(root, x, y)); 		
	}
	
	
	/**
	 * Populate the tree (bfs)
	 * 
	 * @param list
	 * @param values
	 */
	public static void populateTree(List<TreeNode> list, List<Integer> values) {
		while(!list.isEmpty() && !values.isEmpty()) {
			TreeNode node = list.remove(0);
			Integer value = values.remove(0);
			if(value != null) {
				node.left = new TreeNode(value);
				list.add(node.left);
			}
			value = values.remove(0);
			if(value != null) {
				node.right = new TreeNode(value);
				list.add(node.right);
			}
		}
	}
}
