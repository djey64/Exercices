package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * @author jeremypetit-jean
 *
 */
public class E437PathSum3 {

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
	
	private static int sumPaths = 0;
		
	private static void dfs (TreeNode node, List<Integer> sums, int targetSum) {
		if(node == null) return;
		if(node.val == targetSum) sumPaths++;
		
		List<Integer> newSums = new ArrayList<>();
		// recompute sums
		for(int i = 0; i < sums.size(); i++) {
			int sum = sums.get(i) + node.val;
			if(sum == targetSum) sumPaths++;
			newSums.add(sum);
		}
		
		// add node value to sums
		newSums.add(node.val);
		
		// call dfs for childrens
		dfs(node.left, newSums, targetSum);
		dfs(node.right, newSums, targetSum);
	}
	
	
	/**
	 * First solution: compute sums for each node from their ancestors and pass it to childrens
	 * so on and so forth
	 * 
	 * @param root
	 * @param targetSum
	 * @return
	 */
    public static int pathSum(TreeNode root, int targetSum) {
        List<Integer> sums = new ArrayList<>();
        dfs(root, sums, targetSum);
        return sumPaths;
    }
	       
	
	public static void main(String[] args) {
		
		// inputs
		Integer[] arr = new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1};
		int target = 8;
		
		List<Integer> values = new ArrayList<>(Arrays.asList(arr));
		List<TreeNode> list = new ArrayList<>();
		TreeNode root = new TreeNode(values.remove(0));
		list.add(root);
		populateTree(list, values);
		
		pathSum(root, target);
		System.out.println(sumPaths);
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
