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
    public int search(int[] nums, int target) {
        boolean found = false;
        int start = 0; 
        int end = nums.length;
        int pivot = end - start / 2;
        while(!found) {
        	if(nums[pivot] > target) {
        		// TODO
        	} else if(nums[pivot] < target) {
        		// TODO
        	} else {
        		// TODO
        	}
        }
        return pivot;
    }
}
