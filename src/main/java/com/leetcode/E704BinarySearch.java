package com.leetcode;

/**
 * 
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * https://leetcode.com/problems/binary-search/
 * 
 * @author petit-jean
 *
 */
public class E704BinarySearch {
    public static int search(int[] nums, int target) {
    	// optimisation: avoid looking for element that is out of bounds
    	if(nums.length == 0 || nums[0] > target || nums[nums.length -1] < target) return -1;
    	
        int start = 0; 
        int end = nums.length - 1;
        int pivot = (end + start) / 2;
        while(start <= end) {
        	if (nums[pivot] == target) return pivot;
        	if(nums[pivot] > target) 
        		end = pivot - 1;
        	else 
        		start = pivot + 1;
        	
        	pivot = (end + start) / 2;
        }
        return -1;
    }
    
	public static void main(String[] args) {
		
		int[] nums = new int[] {-1,0,3,5,9,12};
		
		int search = search(nums, 12);
		System.out.println(search);
	}    
}
