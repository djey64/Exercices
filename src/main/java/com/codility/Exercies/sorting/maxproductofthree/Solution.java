package com.codility.Exercies.sorting.maxproductofthree;

import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.text.html.MinimalHTMLWriter;

public class Solution {

	public int solution(int[] A) {
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>(2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2);

		for(int i : A) {
			maxHeap.add(i);
		}
		
		maxHeap.forEach(System.out::println);
		return 0;
		
//  n.log(n) solution :
//		Arrays.sort(A);
//		// Try to multiply two minimal values in case of two negative value, will produce positive result
//		int floor = A[0] * A[1] * A[A.length - 1];
//		int ceil = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
//		return floor > ceil ? floor : ceil;
	}
}
