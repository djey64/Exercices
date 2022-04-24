package com.codility.Exercies.sorting.NumberOfDiscIntersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Solution {
	public static int solution(int[] A) {
		List<Integer> starts = new ArrayList<>();
		List<Integer> ends = new ArrayList<>();
		for(int i = 0; i < A.length; i++) {
			starts.add(i - A[i]);
			ends.add(i + A[i]);
		}
		
		Collections.sort(starts);
		Collections.sort(ends);
		
		int openDisks = 0;
		int intersections = 0;
		
		while(starts.size() > 0 && ends.size() > 0) {
			if(starts.get(0) <= ends.get(0)) {
				starts.remove(0);
				intersections += openDisks;
				openDisks++;
			} else {
				ends.remove(0);
				openDisks--;
			}
		}
		return intersections;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 5, 2, 1, 4, 0 } ));
	}
}
