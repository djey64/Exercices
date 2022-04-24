package com.adventofcode.d24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/com/adventofcode/d01/input.txt"))){
			solve(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void solve(BufferedReader reader) throws IOException {
		List<Integer> input = ParseInput(reader);
		Integer previous = null;
		int count = 0;
		for(int i = 2; i < input.size(); i++) {
			int sum = input.get(i - 2) + input.get(i - 1) + input.get(i);
			if (previous != null && previous < sum) 
				count++;
			previous = sum;
		}
		System.out.println(count);
	}

	private static List<Integer> ParseInput(BufferedReader reader) throws IOException {
		List<Integer> input = new ArrayList<>();
		String line = reader.readLine();
		do {
			input.add(Integer.parseInt(line));
			line = reader.readLine();
		} while(line != null);
		return input;
	}
}
