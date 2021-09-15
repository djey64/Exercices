package com.leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 * 
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 * 
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
 * 
 * For i <= k < j:
 *   arr[k] > arr[k + 1] when k is odd, and
 *   arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 *   arr[k] > arr[k + 1] when k is even, and
 *   arr[k] < arr[k + 1] when k is odd.
 * 
 * https://leetcode.com/problems/longest-turbulent-subarray/
 * 
 * @author petit-jean
 *
 */
public class E978LonguestTurbulentSubarray {

	
    public static int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int count = 0;
    	int i = 0;
    	boolean nextShouldBeGreater = true;
    	boolean nextShouldBeMinor = true;
    	while(i < arr.length - 1 ) {
    		if(arr[i] > arr[i + 1] && nextShouldBeGreater) {
    			count++;
    			nextShouldBeGreater = false;
    			nextShouldBeMinor = true;
    			i++;
    		} else if(arr[i] < arr[i + 1] && nextShouldBeMinor) {
    			count++;
    			nextShouldBeGreater = true;
    			nextShouldBeMinor = false;
    			i++;
    		}
    		else {
    			count = 0;
    			nextShouldBeGreater = true;
    			nextShouldBeMinor = true;
    			if(arr[i] == arr[i + 1]) i++;
    		}

    		max = Math.max(max, count + 1);
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		int[] arr = new int[] {4,8,12,16};
		System.out.println(maxTurbulenceSize(arr));
	}
}
