package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeUtils {

	/**
	 * Transform an array to Binary tree (bfs)
	 * @param 
	 * 
	 * @param list
	 * @param values
	 */
	public static  TreeNode fromArray(Integer[] arr) {
		List<Integer> values = new ArrayList<>(Arrays.asList(arr));
		List<TreeNode> list = new ArrayList<>();
		TreeNode root = new TreeNode(values.remove(0));
		list.add(root);
		
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
		
		return root;
	}
}
