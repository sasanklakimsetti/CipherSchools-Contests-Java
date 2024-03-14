package Hackerrank_Contest.CipherSchools_Contests.Contest1;
/*
Charlie and Johnny play a game. For every integer X Charlie gives, Johnny has to find the smallest positive integer Y, such that X * Y contains only 4's and 0's and starts with one or more 4's followed by zero or more 0's. (i.e.), 404 is an invalid number but 400 is a valid number.

If a is the number of 4's and b is the number of 0's, can you print the value of 2 * a + b.

Input Format
The first line contains an integer T. T lines follow, each line containing the integer X as stated above.

Output Format
For every X, print the output 2 * a + b in a newline as stated in the problem statement.

Constraints
1<=T<=103
1<=X<=105

Sample Input #00

3
4
5
80
Sample Output #00

2
3
4
Explanation
For the 1st test-case, the smallest such multiple of 4 is 4 itself. Hence value of a will be 1 and and value of b will be 0. The required value of 2 * a+b is 2.

For the 2nd test-case, Y = 8 and 40 is the minimum such multiple of 5. Hence value of a,b and 2 * a+b will be 1, 1 and 3 respectively.
*/

import java.io.*;
import java.util.*;

class Result1 {

    public static int solve(int x) {
        if (x == 0) // Edge case: If x is 0, return 0
            return 0;
        
        // Find the first multiple of x that contains only 4's and 0's
        int y = x;
        while (!containsOnly4sAnd0s(y)) {
            y += x;
        }
        
        return (countFours(y) * 2) + countZeros(y);
    }
    
    // Check if a number contains only 4's and 0's
    private static boolean containsOnly4sAnd0s(int num) {
        String str = Integer.toString(num);
        for (char digit : str.toCharArray()) {
            if (digit != '4' && digit != '0') {
                return false;
            }
        }
        return true;
    }
    
    // Count the number of '4's in a number
    private static int countFours(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 4) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    
    // Count the number of '0's in a number
    private static int countZeros(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}

public class EasyMath {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int x = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result1.solve(x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
