package knapsack;

public class MemoizedKnapsack {
    private static int[][] memo;

    public static int knapsack(int[] values, int[] weights, int n, int capacity) {
        if (n == 0 || capacity == 0) return 0;
        if (weights[n - 1] > capacity) return knapsack(values, weights, n - 1, capacity);
        if (memo[capacity][n - 1] != -1) return memo[capacity][n - 1];
        int result = Math.max(values[n - 1] + knapsack(values, weights, n - 1, capacity - weights[n - 1]), knapsack(values, weights, n - 1, capacity));
        memo[capacity][n - 1] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30, 40, 50 };
        int[] values = { 60, 100, 120, 240, 300 };
        int n = weights.length;
        int capacity = 100;
        memo = new int[capacity + 1][n + 1];
        for (int i = 0; i < capacity + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(knapsack(values, weights, n, capacity));
    }
}
