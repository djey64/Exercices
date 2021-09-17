package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 * 
 * @author petit-jean
 *
 */
public class E350IntersectionOfTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] mapArray = new int[1001];
    	List<Integer> intersection = new ArrayList<>();
    	int[] resultArray;
    	
        for (int n: nums1) {
        	mapArray[n]++;
        }
        
        for (int n : nums2) {
        	if(mapArray[n] > 0) {
        		intersection.add(n);
        		mapArray[n]--;
        	}
        }

        resultArray = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++) resultArray[i] = intersection.get(i);
        
        return resultArray;
    }
    
    public static void main(String[] args) {
		int[] num1 = new int[] {1,2,2,1};
		int[] num2 = new int[] {2,2};
		
		System.out.println(Arrays.toString(intersect(num1, num2)));
	}
}
