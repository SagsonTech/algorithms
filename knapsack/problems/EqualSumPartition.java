package knapsack.problems;

// Problem statement 
// You are given an array of size n. You have to find if the array can be splitted into two partitions whose sum is equal
// Example:
// arr = {1, 5, 11, 5}
// output = true 
// explanation = the array can be splitted into {11}, {1, 5, 5} such that both their sum is the same == 11 

public class EqualSumPartition {
    public static int findTarget(int[] arr, int n) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % 2 == 0) return sum / 2;
        return -1;
    }

    public static boolean isSumPossible(int[] arr, int n, int target) {
        boolean[][] memo = new boolean[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i][0] = true;
        }
        for (int j = 1; j < target + 1; j++) {
            memo[0][j] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j - arr[i - 1]] || memo[i - 1][j];
                }
            }
        }
        return memo[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5, 1};
        int n = arr.length;
        int target = findTarget(arr, n);
        if (target == -1) {
            System.out.println(false);
        } else {
            System.out.println(isSumPossible(arr, n, target));
        }
    }
}
