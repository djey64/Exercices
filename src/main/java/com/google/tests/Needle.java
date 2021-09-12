package com.google.tests;

import java.io.*;
import java.util.*;

public class Needle {
    public static int count(String needle, InputStream haystack) throws Exception {
        InputStreamReader isReader = new InputStreamReader(haystack);
        BufferedReader reader = new BufferedReader(isReader);
        String str;
        int count = 0;
        while((str = reader.readLine())!= null) {
        	if(str.contains(needle)) count++;
        }
        return count;
    }
    
    public static void main(String[] args) throws Exception {
        String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

        try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
            System.out.println(Needle.count("there", inStream));
        }
    }
}