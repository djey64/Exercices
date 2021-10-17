package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	
	private static int dfs (TreeNode node, int sum, Map<Integer, Integer> sums, int targetSum) {
		if(node == null) return 0;
		
		sum += node.val;
		int count = sums.getOrDefault(sum - targetSum, 0);
		
		sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		
		// call dfs for childrens
		count += dfs(node.left, sum, sums, targetSum);
		count += dfs(node.right, sum, sums, targetSum);
		
		sums.put(sum, sums.getOrDefault(sum, 0) - 1);
		return count;
	}
	
	/**
	 * Second solution, instead of spread list of sums of each ancestor,
	 * we simply spread the sum, keep track of previous sums, and try to know if 
	 * minus complement could be found in map
	 * 
	 * @param root
	 * @param targetSum
	 * @return
	 */
    public static int pathSum(TreeNode root, int targetSum) {
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 1);
    	return dfs(root, 0, map, targetSum);
    }
	       	
    // Tests
	public static void main(String[] args) {
		
		// inputs
		Integer[] arr = new Integer[] {0, 1, 1};
		int target = 1;
		
		List<Integer> values = new ArrayList<>(Arrays.asList(arr));
		List<TreeNode> list = new ArrayList<>();
		TreeNode root = new TreeNode(values.remove(0));
		list.add(root);
		populateTree(list, values);
		
		System.out.println(pathSum(root, target)); 
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
