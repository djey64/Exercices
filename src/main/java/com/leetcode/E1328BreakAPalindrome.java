package com.leetcode;

import java.util.Arrays;



/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character 
 * with any lowercase English letter so that the resulting string is not a palindrome and 
 * that it is the lexicographically smallest one possible.
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 * A string a is lexicographically smaller than a string b (of the same length) if in the 
 * first position where a and b differ, a has a character strictly smaller than the corresponding
 * character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first
 *  position they differ is at the fourth character, and 'c' is smaller than 'd'.
 * 
 * https://leetcode.com/problems/break-a-palindrome/
 * 
 * @author petit-jean
 *
 */
public class E1328BreakAPalindrome {
    public static String breakPalindrome(String palindrome) {
    	if(palindrome.length() == 1) return "";
    	// First try to minimize
    	for(int i = 0; i < palindrome.length() / 2; i++) {
        	char c = palindrome.charAt(i);
        	if(c > 'a') {
        		char[] arr = palindrome.toCharArray();
        		arr[i] = 'a';
        		return String.valueOf(arr);
        	}
        }
    	// If no minimize is possible, we have to maximize from the right 
		char[] arr = palindrome.toCharArray();
		arr[arr.length - 1] = 'b';
		return String.valueOf(arr);
    }
    
    public static void main(String[] args) {
    	System.out.println(breakPalindrome("aabaa"));
	}
}
