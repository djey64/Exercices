package com.codility.Exercies.prefixsums.countdiv;

public class Solution {

	public int solution(int A, int B, int K) {
		System.out.println(((double) B - (double) A + 1d ) / (double) K);
		if(A == B) return (A / K);
		else if (K == A || K == B) return (int) (Math.round(((double) B - (double) A + 1d ) / (double) K)) + 1;
		else return (int) (Math.round(((double) B - (double) A + 1d ) / (double) K));
	}
}
