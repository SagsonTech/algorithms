package unbounded_knapsack.problems;

// problem statement - 
// You are given a rod of length N and a list of prices that contains the prices of all pieces of size smaller than or equal to N.
// The rod can be cut into smaller pieces of integer lengths.
// You can sell each piece of length i at price[i].
// You may cut the rod in any number of ways (or not cut it at all).
// The same piece length can be chosen multiple times (unbounded).
// Your task is to determine the maximum revenue obtainable by cutting the rod and selling the pieces.

public class RodCuttingProblem {
    public static int findMaximumProfit(int[] length, int[] prices, int n, int maxLength) {
        int[][] dp = new int[n + 1][maxLength + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < maxLength + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < maxLength + 1; j++) {
                if (length[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][maxLength];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = prices.length;
        int[] length = new int[n];
        for (int i = 0; i < n; i++) length[i] = i + 1;
        System.out.println(findMaximumProfit(length, prices, n, n));
    }
}
