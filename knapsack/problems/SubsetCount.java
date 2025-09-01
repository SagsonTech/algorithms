package knapsack.problems;

// problem statement: 
// You are given an array of size n and a target. You are expected to find the number of subsets present in the array that sum to the given target 
// Example: 
// arr = {2, 3, 5, 8, 10}, target = 10
// output = 3
// Explanation: 
// We have 3 subsets that sum to 10 - {2, 3, 5}, {2, 8}, {10} 

public class SubsetCount {
    public static int findSubsetCount(int[] arr, int n, int target) {
        int[][] memo = new int[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i][0] = 1;
        }
        for (int j = 1; j < target + 1; j++) {
            memo[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j - arr[i - 1]] + memo[i - 1][j];
                }
            }
        }
        return memo[n][target];
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 10};
        int n = arr.length;
        int target = 10;
        System.out.println(findSubsetCount(arr, n, target));
    }
}
