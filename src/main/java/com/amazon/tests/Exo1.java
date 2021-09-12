package com.amazon.tests;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/*
 * 191
[66, 86, 82, 68, 80, 86, 69, 92, 47, 83, 81, 44, 83, 5, 57, 90, 54, 89, 86, 37, 56, 98, 76, 14, 21, 55, 81, 78, 94, 88, 26, 25, 36, 81, 65, 86, 99, 4, 31, 83, 78, 3, 86, 47, 62, 82, 42, 23, 10, 70, 28, 62, 98, 42, 7, 48, 95, 21, 90, 85, 85, 9, 5, 5, 54, 18, 36, 95, 66, 45, 37, 67, 75, 50, 74, 24, 72, 72, 85, 94, 60, 28, 14, 91, 52, 93, 98, 44, 29, 75, 89, 50, 59, 97, 35, 61, 55, 15, 63, 57, 62, 84, 52, 47, 58, 20, 39, 3, 92, 90, 32, 68, 71, 96, 4, 39, 55, 62, 95, 20, 90, 80, 20, 73, 99, 94, 93, 91, 64, 55, 94, 46, 10, 77, 36, 61, 38, 42, 66, 28, 10, 96, 22, 49, 61, 37, 70, 47, 19, 46, 77, 32, 0, 24, 70, 77, 98, 48, 85, 33, 33, 79, 93, 64, 43, 89, 54, 15, 16, 67, 87, 98, 24, 30, 95, 4, 10, 39, 0, 72, 91, 48, 88, 43, 73, 60, 15, 3, 20, 53, 85, 25, 33, 25, 76, 93, 65, 95, 96, 22, 51, 44, 47, 66, 0, 45, 23, 11, 55, 54, 2, 23, 0, 52, 4, 44, 77, 99, 7, 15, 4, 51, 63, 76, 29, 24, 3, 37, 55, 87, 24, 30, 60, 15, 40, 36, 82, 0, 46, 12, 20, 63, 60, 35, 77, 51, 34, 5, 43, 49, 84, 93, 99, 94, 25, 97, 76, 36, 86, 54, 97, 62, 93, 87, 83, 54, 48, 0, 87, 72, 0, 20, 88, 37, 11, 23, 95, 83, 51, 24, 24, 11, 64, 73, 56, 76, 73, 74, 55, 50, 54, 22, 88, 67, 30, 80, 83, 24, 94, 2, 7, 44, 21, 55, 4, 80, 73, 90, 71, 34, 30, 9, 94, 16, 82, 75, 40, 39, 45, 89, 66, 17, 13, 39, 60, 58, 89, 2, 49, 22, 89, 41, 73, 80, 46, 1, 95, 57, 79, 93, 85, 0, 11, 66, 53, 88, 53, 74, 50, 34, 40, 31, 4, 45, 57, 19, 20, 36, 25, 77, 60, 35, 91, 66, 58, 20, 5, 82, 86, 92, 14, 44, 4, 19, 28, 77, 58, 48, 79, 63, 63, 94, 58, 92, 85, 75, 92, 67, 85, 12, 94, 69, 17, 47, 39, 17, 73, 53, 67, 57, 88, 70, 9, 71, 64, 77, 54, 20, 93, 43, 7, 90, 63, 94, 99, 0, 87, 42, 8, 70, 11, 78, 48, 78, 15, 71, 57, 82, 39, 42, 30, 56, 7, 75, 75, 26, 73, 38, 58, 80, 61, 49, 1, 23, 73, 18, 27, 51, 39, 6, 12, 42, 93, 70, 71, 72, 3, 78, 49, 73, 19, 63, 57, 44, 0, 49, 46, 40, 82, 8, 6, 45, 90, 70, 41, 82, 58, 66, 38, 80, 64, 92, 87, 9, 3, 1, 47, 58, 24, 40, 3, 86, 78, 70, 13, 92, 21, 28, 65, 74, 48, 41, 68, 71, 38, 71, 19, 38, 21, 83, 64, 92, 44, 51, 7, 56, 50, 62, 28, 77, 75, 49, 87, 4, 60, 27, 91, 71, 77, 81, 59, 68, 35, 1, 75, 54, 42, 15, 83, 20, 11, 20, 97, 59, 47, 31, 23, 15, 22, 58, 62, 41, 80, 66, 22, 64, 48, 13, 89, 56, 70, 67, 38, 18, 82, 62, 58, 89, 9, 87, 57, 40, 79, 46, 33, 25, 2, 5, 35, 78, 42, 67, 29, 66, 50, 42, 5, 54, 62, 16, 98, 92, 53, 74, 97, 40, 69, 14, 15, 77, 61, 5, 49, 98, 18, 35, 64, 38, 28, 43, 59, 85, 11, 19, 77, 37, 91, 26, 23, 18, 71, 34, 10, 95, 77, 86, 40, 33, 49, 52, 9, 54, 14, 16, 52, 78, 32, 14, 15, 45, 35, 75, 63, 31, 37, 50, 51, 6, 59, 24, 72, 51, 43, 14, 49, 81, 76, 48, 59, 54, 82, 89, 68, 60, 41, 89, 4, 87, 60, 44, 44, 68, 20, 97, 27, 65, 31, 44, 30, 2, 46, 74, 34, 3, 58, 77, 74, 6, 14, 67, 95]
 * result faux : 48
 * 
 */


public class Exo1 {
	
	    /*
	     * Complete the 'finalInstances' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. INTEGER instances
	     *  2. INTEGER_ARRAY averageUtil
	     */

	    public static int finalInstances(int instances, List<Integer> averageUtil) {
	        int i = 0;
	        while(i < averageUtil.size()) {
	            if(averageUtil.get(i) < 25 && instances > 1) {
	                instances = (int) Math.ceil(instances / 2d);
	                i += 10;
	            } else if (averageUtil.get(i) > 60 && instances <= 10e8) {
	                instances *= 2;
	                i += 10;
	            } else {
	                i++;
	            }
	        }

	        return instances;
	    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int instances = Integer.parseInt(bufferedReader.readLine().trim());

        int averageUtilCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> averageUtil = IntStream.range(0, averageUtilCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = finalInstances(instances, averageUtil);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
