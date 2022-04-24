package com.codility.Exercies.stackqueues.brackets;

import java.util.Stack;

/**
 * 
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * 
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * 
 * 
 * @author jeremypetit-jean
 *
 */

class Solution {
    public static int solution(String S) {
    	char[] arr = S.toCharArray();
    	Stack<String> stack = new Stack<>();
    	for(char c: arr) {
    		if(isClosing(c)) {
				if(stack.isEmpty() || !getOpening(c).equals(stack.pop())) return 0;
    		} else {
        		stack.add(c + "");
    		}
    	}
    	
    	return stack.isEmpty() ? 1 : 0;
    }
    
    public static boolean isClosing(char c) {
    	return c == '}' || c == ']' || c == ')';
    }

    public static String getOpening(char c) {
    	switch(c) {
	    	case '}': 
	    		return "{";
	    	case ']': 
	    		return "[";
	    	case ')': 
	    		return "(";
    	}
    	return "should never happen";
    }

	public static void main(String[] args) {
		System.out.println(solution("{[()()]}"));
	}
}
