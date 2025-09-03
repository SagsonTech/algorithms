package unbounded_knapsack;

public class UnboundedKnapsack {
    public static int unboundKnapsack(int[] values, int[] weights, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(values[i - 1] + dp[i][j - weights[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int[] weights = { 2, 3, 4 };
        int[] values = { 10, 14, 16 };
        int n = weights.length;
        int capacity = 10;
        System.out.println(unboundKnapsack(values, weights, n, capacity));
    }
}
