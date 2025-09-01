package knapsack.problems;

// problem statement 
// You are given an array arr of size n and a target sum target. You have to determine the possibilty of finding such a subset form the array, whose sum is equal to the target 
// Example :
// arr = {2, 3, 4, 8}, target = 6
// output = true 
// since, we have the subset {2,4} whose sum = 6 

public class SubsetSumPossibility {
    public static boolean isSubsetPossible(int[] arr, int n, int target) {
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
        int[] arr = {2, 3, 4, 8};
        int n = arr.length;
        int target = 16;
        System.out.println(isSubsetPossible(arr, n, target));
    }
}
