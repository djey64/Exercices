package com.adventofcode.d01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/com/adventofcode/d01/input.txt"))){
			String line;
			Integer previous = null;
			int count = 0;
			line = reader.readLine();
			do {
				int current = Integer.parseInt(line);
				if(previous != null && current > previous) 
					count++;
				previous = current;
				line = reader.readLine();
			} while(line != null);
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
