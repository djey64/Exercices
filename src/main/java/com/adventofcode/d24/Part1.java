package com.adventofcode.d24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {

	private static final String W = "w";
	private static final String X = "x";
	private static final String Y = "y";
	private static final String Z = "z";
	
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/com/adventofcode/d24/input.txt"))){
			solve(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void solve(BufferedReader reader) throws IOException {
		Map<String, Integer> variables = initVariables();
		//  Test
		variables.put(W, 8);
		String line = reader.readLine();
		line = reader.readLine();
		do {
			Operation op = Operation.parse(variables, line.split(" "));
			debugVariables(variables);
			System.out.println(line);
			System.out.println(op);
			variables.put(op.variableName, apply(op));
			debugVariables(variables);
			line = reader.readLine();
		} while(line != null);
		System.out.println(variables.get(Z));
	}
	
	private static void debugVariables(Map<String, Integer> variables) {
		StringBuilder sb = new StringBuilder();
		sb.append(W + "=" + variables.get(W));
		sb.append(" "+X + "=" + variables.get(X));
		sb.append(" "+Y + "=" + variables.get(Y));
		sb.append(" "+Z + "=" + variables.get(Z));
		System.out.println(sb.toString());

	}
	
	private static class Operation {

		String operation;
		String variableName;
		int a;
		int b;
		
		private Operation(String op, int a, int b, String variableName) {
			this.operation = op;
			this.a = a;
			this.b = b;
			this.variableName = variableName;
		}
		
		public static Operation parse(Map<String, Integer> variables, String[] line) {
			int a = variables.get(line[1]);
			int b = Integer.MAX_VALUE;
			try {
				b = Integer.parseInt(line[2]);
			} catch (Exception e) {
				b = variables.get(line[2]);
			}
			return new Operation(line[0], a, b, line[1]);
		}
		
		@Override
		public String toString() {
			return "op: " + operation + ", a: "+a+", b: "+b + " set "+variableName;
		}
	}
	
	private static int apply(Operation op) {
		
		switch(op.operation) {
			case "mul":
				return op.a * op.b;
			case "add":
				return op.a + op.b;
			case "mod":
				return op.a % op.b;
			case "eql":
				return op.a == op.b ? 1 : 0;
			case "div":
				return (int) Math.round(op.a / op.b);
		}
		throw new IllegalArgumentException("unrecognized operation");
	}
	
	private static Map<String, Integer> initVariables() {
		Map<String, Integer> variables = new HashMap<>();
		variables.put(W, 0);
		variables.put(X, 0);
		variables.put(Y, 0);
		variables.put(Z, 0);
		return variables;
	}
}
