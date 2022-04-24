package com.codility.Exercies.sorting.triangle;

import java.util.Arrays;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static int solution(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i <= A.length - 3; i++) {
			long p = A[i], q = A[i + 1], r = A[i + 2]; 
			
			if (p + q > r && q + r > p
					&& r + p > q) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } ));
	}
}
