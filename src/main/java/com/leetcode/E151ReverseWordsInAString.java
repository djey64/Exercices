package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author petit-jean
 *
 */
public class E151ReverseWordsInAString {

    public static String reverseWords(String s) {
        List<String> list = Arrays.stream(s.split(" ")).filter(word -> !word.isEmpty()).collect(Collectors.toList());
        
        for(int i = 0, j = 0; i < j ; i++, j--) {
        	
        }
        
        return String.join(" ", list);
    }
	
	
	public static void main(String[] args) {
		
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}
