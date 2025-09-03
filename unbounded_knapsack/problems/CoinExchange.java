package unbounded_knapsack.problems;

// You are given an integer array coins[] of size N representing different denominations of coins, and an integer amount representing a total sum.
// You have infinite supply of each coin (unbounded).
// You need to find the number of distinct ways to make up the amount using these coins.
// Order of coins does not matter (i.e., {1,2} and {2,1} are considered the same combination).

public class CoinExchange {
    public static int findNumberOfWays(int[] coins, int n, int amount) {
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int n = coins.length;
        int amount = 5;
        System.out.println(findNumberOfWays(coins, n, amount));
    }
}
