package com.leetcode;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

public class E130SurroundedRegions {
	
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED

	public static enum From {
		LEFT,
		RIGHT,
		TOP,
		BOTTOM,
		NONE
	}
	
	public static final char O = 'O';
	public static final char X = 'X';
	
	public static Map<SimpleEntry<Integer, Integer>, Boolean> memo = new HashMap<>();
	
	public static boolean isBorder(char[][] board, int x, int y) {
		return x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1;
	}

	public static boolean hasLeft(char[][] board, int x, int y) {
		return x > 0;
	}

	public static boolean hasRight(char[][] board, int x, int y) {
		return x < board.length - 1;
	}
  
	public static boolean hasBottom(char[][] board, int x, int y) {
		return y < board[0].length - 1;
	}

	public static boolean hasTop(char[][] board, int x, int y) {
		return y > 0;
	}
	
	public static SimpleEntry<Integer, Integer> getLeft(int x, int y) {
		return new SimpleEntry<Integer, Integer>(x - 1, y);
	}

	public static SimpleEntry<Integer, Integer> getRight(int x, int y) {
		return new SimpleEntry<Integer, Integer>(x + 1, y);
	}

	public static SimpleEntry<Integer, Integer> getTop(int x, int y) {
		return new SimpleEntry<Integer, Integer>(x, y - 1);
	}

	public static SimpleEntry<Integer, Integer> getBottom(int x, int y) {
		return new SimpleEntry<Integer, Integer>(x, y + 1);
	}

	public static boolean isConnected(char[][] board, int x, int y, From from) {
    	print(board, x, y);
		SimpleEntry<Integer, Integer> key = new SimpleEntry<>(x, y);
		if(memo.containsKey(key)) return memo.get(key);
		if(board[x][y] == X) 
			return false;
		if (isBorder(board, x, y)) {
			return true;
		}

		boolean hasLeft = hasLeft(board, x, y);
		boolean hasRight = hasRight(board, x, y);
		boolean hasTop = hasTop(board, x, y);
		boolean hasBottom = hasBottom(board, x, y);
		
		SimpleEntry<Integer, Integer> left = getLeft(x, y);
		SimpleEntry<Integer, Integer> right = getRight(x, y);
		SimpleEntry<Integer, Integer> top = getTop(x, y);
		SimpleEntry<Integer, Integer> bottom = getBottom(x, y);
		boolean isConnected = (hasLeft && from != From.LEFT && isConnected(board, left.getKey(), left.getValue(), From.RIGHT)) ||
				(hasRight && from != From.RIGHT && isConnected(board, right.getKey(), right.getValue(), From.LEFT)) ||
				(hasTop && from != From.TOP && isConnected(board, top.getKey(), top.getValue(), From.BOTTOM)) ||
				(hasBottom && from != From.BOTTOM && isConnected(board, bottom.getKey(), bottom.getValue(), From.TOP));
		
		if(from == From.NONE) memo.put(key, isConnected);
		return isConnected;
	}
	
    public static void solve(char[][] board) {
        
    	for()
    	
    	for(int x = 0; x < board.length; x++) {
        	for(int y = 0; y < board[0].length; y++) {
        		if(!isConnected(board, x, y, From.NONE))
        			board[x][y] = X;
        	}
    	}
    }
    
    public static void main(String[] args) {
    	char[][] board = {{X,X,X,X,X},{X,O,O,O,X}, {X,X,O,O,X}, {X,X,X,O,X}, {X,O,X,X,X}};
    	print(board, -1, -1);
    	solve(board);
    	print(board, -1, -1);
	}
    
    public static void print(char[][] board, int x, int y) {
    	for(int i = 0; i < board.length; i++) {
    		StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < board[0].length; j++) {
        		if(i == x && j == y) 
        			sb.append("("+ board[i][j] + "), ");
        		else
        			sb.append(board[i][j] + ", ");
        	}
        	System.out.println(sb);
    	}
    	System.out.println("");
    }
    
}
