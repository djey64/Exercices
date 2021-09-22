package com.leetcode;

import java.util.Arrays;

public class E4MergeOfTwoSortedArrays {
	
	
	/**
	 * Basic way to solve it, merge the two arrays in linear time and 
	 * return the middle of the array
	 * 
	 * O(n+m) solution
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int[] merged = new int[nums1.length + nums2.length];
		int j = 0, k = 0;
		for(int i = 0; i < merged.length; i++){
			if(k >= nums2.length || (j < nums1.length && nums1[j] <= nums2[k])) 
				merged[i] = nums1[j++];
			else {
				merged[i] = nums2[k++];
			}
		}
		System.out.println(Arrays.toString(merged));
		
		if(merged.length == 1) return merged[0];
		return merged.length % 2 == 0 ? (merged[(merged.length / 2) - 1] + merged[(merged.length / 2)] ) / 2d : merged[merged.length / 2];
	}
	
	/**
	 * Optimized way:
	 * Use binary search
	 * 
	 * O(log(n+m)) solution
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] n1, int[] n2) {
		// Always take smaller array as nums1
		int[] nums1 = n1.length <= n2.length ? n1 : n2;
		int[] nums2 = n1.length > n2.length ? n1 : n2;
		
		int total = nums1.length + nums2.length;
		int half = total / 2;
		
		if(nums1.length == 0) 
			return getMedian(nums2);
		else if(nums2.length == 0)
			return getMedian(nums1);
		
		// Left and right pointers (binary search)
		int l = 0;
		int r = nums1.length - 1;
		
		while(l <= r) {
			int m = (l + r) / 2;
			// get complement index of nums2 from current index of num1
			int m2 = half - (m + 1) - 1;
			if((m2 == nums2.length - 1 || nums1[m] <= nums2[m2 + 1]) && (m == nums1.length -1 || nums2[m2] <= nums1[m + 1])) {
				// We've found the left partition of the merged array
				
				int minOfNextElements = Math.min(getNextValueOrDefault(nums1, m, Integer.MAX_VALUE), getNextValueOrDefault(nums2, m2, Integer.MAX_VALUE));
				if(total % 2 == 0) { 
					// Even case
					return (Math.max(nums1[m], nums2[m2]) + minOfNextElements) / 2d;
				} else { 
					// Odd case
					return minOfNextElements;
				}
			} else if (nums2[m2 + 1] <= nums1[m]){
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		// case when 
		return total % 2 == 0 
				? (getElementAt(half - 1, nums1, nums2) + getElementAt(half, nums1, nums2)) / 2 
				: getElementAt(half - 1, nums1, nums2);
	}	
	
	// get element at index simulate arr1 and arr2 are merged
	private static double getElementAt(int index, int[] arr1, int[] arr2) {
		return index < arr1.length ? arr1[index] : arr2[index - arr1.length];
	}
	
	// Get next element of array or else defaultValue
	private static int getNextValueOrDefault(int[] arr, int index, int defaultValue) {
		return index < arr.length - 1 ? arr[index + 1] : Integer.MAX_VALUE;
	}
	
	private static double getMedian(int[] arr) {
		int middle = arr.length / 2;
		if(arr.length % 2 == 0) 
			return (arr[middle] + arr[middle + 1]) / 2;
		else 
			return arr[middle];
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3 };
		int[] nums2 = new int[] { 4, 5, 6 };
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArrays2(nums1, nums2));
				
		
	}
	
	
}
