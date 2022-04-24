package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class E1143LonguestCommonSubsequence {
	
	public static String TEST = "BLALBA";
	
	private static class SubSequence {
		
		private int index = 0;
		
		private List<SubSequence> childs = new ArrayList<SubSequence>();
		
		public SubSequence(int index) {
			this.index = index;
		}
		
		public List<SubSequence> getChilds() {
			return childs;
		}
		
		public void addChild(SubSequence child) {
			childs.add(child);
		}
	}
	
    public static int longestCommonSubsequence(String text1, String text2) {
        Map<String, List<Integer>> charIndexes = new HashMap<>();
        
        // Run through text2 and map every char to their found indexes
        for(int i = 0; i < text2.length(); i++) {
        	char c = text2.charAt(i);
        	String key = String.valueOf(c);
        	if(charIndexes.containsKey(key)) {
        		charIndexes.get(key).add(i);
        	} else {
        		List<Integer> list = new ArrayList<>();
        		list.add(i);
        		charIndexes.put(key, list);
        	}
        }
        
        List<SubSequence> subTrees = new ArrayList<>();
        
        for(int i = 0; i < text1.length(); i++) {
        	char c = text1.charAt(i);
        	String key = String.valueOf(c);
        	if(charIndexes.containsKey(key)) {
        		Set<Integer> alreadyInSequence = new HashSet<>();
        		for(int index: charIndexes.get(key)) {
        			
        			
        			
        			for(SubSequence root: subTrees) {
        				if(root.index < index) {
        					sub.add(index);
        				}
        			}
        			if(!alreadyInSequence.contains(index)) {
        				SubSequence sub = new SubSequence(1, index);
        				subsequencesIndexes.add(sub);
    					visited.add(sub);
    					alreadyInSequence.add(index);
        			}
        		}
        	}
        }
        
        return subsequencesIndexes.stream().map(sub -> sub.length).max(Integer::compare).orElse(0);
    }
    
    public static void assertEqual(int expected, int actual) throws Exception {
    	if(expected != actual) {
    		throw new Exception(expected+" != "+actual);
    	}
    }
    
	public static void main(String[] args) throws Exception {
//		assertEqual(3, longestCommonSubsequence("abcde", "ace"));
//		assertEqual(3, longestCommonSubsequence("abc", "abc"));
//		assertEqual(0, longestCommonSubsequence("abc", "def"));
//		assertEqual(5, longestCommonSubsequence("abcba", "abcbcba"));
//		assertEqual(8, longestCommonSubsequence("aaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaa"));
		assertEqual(6, longestCommonSubsequence("mhqziwb", "mhziwbq"));
//		assertEqual(6, longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
		System.out.println("Success !!!!");
	}
}


