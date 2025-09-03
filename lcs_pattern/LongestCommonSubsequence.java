package lcs_pattern;

import java.util.Scanner;

// Given two strings X and Y, find the length of the longest subsequence that is common to both strings.
// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
// For example, "abc", "abg", "bdf", "aeg", "acefg", .. are subsequences of "abcdefg".
// Input:
// X = "ABCBDAB"
// Y = "BDCAB"

// Output:
// 4

// Explanation:
// The longest common subsequences are "BCAB" and "BDAB", both of length 4.

public class LongestCommonSubsequence {
    public static int findLongestCommonSubsequence(String x, String y, int n, int m) {
        // base condition 
        if (n == 0 || m == 0) return 0;
        // choice diagram 
        if (x.charAt(n - 1) == y.charAt(m - 1)) return findLongestCommonSubsequence(x, y, n - 1, m - 1) + 1;
        return Math.max(findLongestCommonSubsequence(x, y, n - 1, m), findLongestCommonSubsequence(x, y, n, m - 1));
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        System.out.println("The longest common subsequence is: " + findLongestCommonSubsequence(x, y, x.length(), y.length()));
        sc.close();
    }
}
