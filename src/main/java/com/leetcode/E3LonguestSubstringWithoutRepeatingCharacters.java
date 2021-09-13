package com.leetcode;

import java.util.HashSet;


/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * See more here: 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author jeremypetit-jean
 *
 */
public class E3LonguestSubstringWithoutRepeatingCharacters {

	/**
	 * Here I'm using sliding window to iterate over the input string
	 * using an hashset to store encountered characters,
	 * when found a duplicate char, we pop from the start index until we removed duplicate char.
	 * continue this way until the end of string.
	 * 
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
    	HashSet<String> subString = new HashSet<>();
    	int maxLength = 0;
    	
    	int start = 0;
    	int end = 0;
    	
    	while(end < s.length()) {
    		char cEnd = s.charAt(end);
    		if(subString.contains(String.valueOf(cEnd))) {
    			while(subString.contains(String.valueOf(cEnd))) {
    	    		char cStart = s.charAt(start);
    				subString.remove(String.valueOf(cStart));
    				start++;
    			}
    		} 
			subString.add(String.valueOf(cEnd));
			maxLength = Math.max(maxLength, subString.size());
    		end++;
    	}
    	return maxLength;
    }	
}
