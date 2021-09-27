package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 * 
 * https://leetcode.com/problems/unique-email-addresses/
 * 
 * @author jeremypetit-jean
 *
 */
public class E929UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
    	
    	Set<String> uniq = new HashSet<>();
    	
    	for(String mail: emails) {
    		String[] split = mail.split("@");

    		String localName = split[0];
    		String domainName = split[1];
    		
    		int i = 0;
    		StringBuilder s = new StringBuilder();
    		while (i < localName.length() && localName.charAt(i) != '+')  {
    			if(localName.charAt(i) != '.') {
    				s.append(localName.charAt(i));
    			}
    			i++;
    		}
    		
    		uniq.add(s.toString() + '@' + domainName);
    	}
    	
    	return uniq.size();
    }
	
	public static void main(String[] args) {
		
		String[] s = new String[] { "a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		System.out.println(numUniqueEmails(s));
	
	}
}
