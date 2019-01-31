package com.codility.Exercies.permmissingelem;

public class Solution {

    public int solution() {
        int[] A = new int[7];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 5;
        A[4] = 6;
        A[5] = 4;
        A[6] = 8;

        float fact = factoriel(A.length + 1);
        for(int elt : A) {
            fact -= elt;
        }
        return (int) fact;
    }

    private long factoriel(long n) {
        return n * (n + 1) / 2;
    }

}
