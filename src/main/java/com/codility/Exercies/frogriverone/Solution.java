package com.codility.Exercies.frogriverone;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int solution() {
        int A[] = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;
        return solution(5, A);
    }

    public int solution(int X, int A[]) {
//		To slow 
//    	Set<Integer> needed = IntStream.range(1, X + 1).boxed().collect(Collectors.toSet());
    	
    	Set<Integer> needed = new HashSet<>();
    	for(int i = 1; i < X + 1; i++) {
    		needed.add(i);
    	}
    	for(int i = 0; i < A.length; i++) {
    		needed.remove(A[i]);
    		if(needed.isEmpty()) return i;
    	}
        return -1;
    }
}
