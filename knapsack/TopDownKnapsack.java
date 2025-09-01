package knapsack;

public class TopDownKnapsack {
    private static int[][] memo;

    public static int knapsack(int[] values, int[] weights, int n, int capacity) {
        memo = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {           
            for (int w = 1; w <= capacity; w++) { 
                if (weights[i - 1] <= w) {
                    memo[i][w] = Math.max(
                        values[i - 1] + memo[i - 1][w - weights[i - 1]],
                        memo[i - 1][w]
                    );
                } else {
                    memo[i][w] = memo[i - 1][w];
                }
            }
        }

        return memo[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30, 40, 50 };
        int[] values = { 60, 100, 120, 240, 300 };
        int n = weights.length;
        int capacity = 100;
        System.out.println(knapsack(values, weights, n, capacity));
    }
}
