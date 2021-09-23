package com.leetcode;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author petit-jean
 *
 */
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
		int[] A = n1.length <= n2.length ? n1 : n2;
		int[] B = n1.length > n2.length ? n1 : n2;
		
		int total = A.length + B.length;
		int half = total / 2;
		
		if(A.length == 0) 
			return getMedian(B);
		else if(B.length == 0)
			return getMedian(A);
		
		// Left and right pointers (binary search)
		int l = 0;
		int r = A.length - 1;
		
		while(true) {
			// Binary search mid point computation (Warning here !)
			int ma = (int) Math.floor(l + (r - l) / 2.0);
			// get complement index of nums2 from current index of num1
			int mb = half - ma - 2;
			
			int aLeft = ma >= 0 ? A[ma] : Integer.MIN_VALUE;
			int aRight = (ma + 1) < A.length ? A[ma + 1] : Integer.MAX_VALUE;
			int bLeft = mb >= 0 ? B[mb] : Integer.MIN_VALUE;
			int bRight = (mb + 1) < B.length ? B[mb + 1] : Integer.MAX_VALUE;
			
			
			if(aLeft <= bRight && bLeft <= aRight) {
				// We've found the left partition of the merged array
				if(total % 2 == 0) { 
					// Even case
					return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2d;
				} else { 
					// Odd case
					return Math.min(aRight, bRight);
				}
			} else if (aLeft > bRight){
				r = ma - 1;
			} else {
				l = ma + 1;
			}
		}
	}
	
	private static double getMedian(int[] arr) {
		int middle = (arr.length - 1) / 2;
		if(arr.length % 2 == 0) 
			return arr[middle] + (arr[middle + 1] - arr[middle]) / 2.0;
		else 
			return arr[middle];
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { };
		int[] nums2 = new int[] { 2, 3 };
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArrays2(nums1, nums2));
	}
}
