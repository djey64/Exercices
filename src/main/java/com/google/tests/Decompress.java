package com.google.tests;

import java.util.Scanner;

public class Decompress {

	private static String decompress(int n, String s) {
		String decompressed = "";
		for(int x = 0; x < n; x++) {
			for(int i = 0; i < s.length(); i++) {
				if (Character.isLetter(s.charAt(i))) {
					decompressed += s.charAt(i);
				} else {
					Scanner scan = new Scanner(s);
					int times = scan.useDelimiter("[^\\d]+").nextInt();
					scan.close();
					String subStr = getNextSubString(s);
					return decompress(times, subStr);
				}
			}
		}
		return decompressed;
	}
	
	private static String getNextSubString(String s) {
		int start = s.indexOf('[') + 1;
		int end = start + 1;
		int openningCount = 0;
		while(end < s.length()) {
			if(s.charAt(end) == ']')
				if(openningCount > 0) 
					openningCount--;
				else
					break;
			else if(s.charAt(end) == '[') 
				openningCount++;
			end++;
		}
		return s.substring(start, end);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(decompress(1, "3[ab4[c]]2[ab]"));
	}
}

