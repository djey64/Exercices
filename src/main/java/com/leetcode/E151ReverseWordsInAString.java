package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static String reverseWords1(String s) {
        List<String> list = Arrays.stream(s.split(" ")).filter(word -> !word.isEmpty()).collect(Collectors.toList());
        
        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--) {
        	sb.append(list.get(i)).append(" ");
        }
        
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    
    public static String reverseWords(String s) {
    	Matcher m = Pattern.compile("\\w+").matcher(s);
        StringBuffer sb = new StringBuffer();
        System.out.println(m.groupCount());
        while(m.find()) {
        	m.appendTail(sb);
//        	sb.append(m.)).append(" ");
		}
        return sb.deleteCharAt(sb.length() - 1).toString();
	}
	
	
	public static void main(String[] args) {
		
		String s = "the       sky is blue";
		System.out.println(reverseWords(s));
	}
}
