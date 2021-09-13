package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * 
 * https://leetcode.com/problems/maximum-number-of-balloons/
 * 
 * @author jeremypetit-jean
 *
 */

public class E1189MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
     
    	int b = 0, a = 0, l = 0, o = 0, n = 0;
    	
    	for (int i = 0; i < text.length(); i++) {
    		char c = text.charAt(i);
    		switch(c) {
				case 'b': b++; break;
				case 'a': a++; break;
				case 'l': l++; break;
				case 'o': o++; break;
				case 'n': n++; break;
    		}
    	}
    	return Collections.min(Arrays.asList(b, a, l / 2, o / 2, n));
    }
}
