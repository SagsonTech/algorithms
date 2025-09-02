package knapsack.problems;

import java.util.ArrayList;
import java.util.List;

// Problem statement 
// You are given an array of size n and you have to minimize the difference between the sums of different subsets of the array 
// Example 
// arr = {1, 2, 7}
// output = 4
// since {1, 2} => 3, {7} => 7 ==> |3 - 7| = 4 is the minimum difference of the sums of possible subsets 

public class MinimumSubsetSumDifference {
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    public static boolean isSubsetSumPossible(int[] arr, int n, int sum) {
        boolean[][] memo = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            memo[0][j] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j - arr[i - 1]] || memo[i - 1][j];
                }
            }
        }
        return memo[n][sum];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int n = arr.length;
        int sum = findSum(arr);
        List<Integer> partition1Sums = new ArrayList<>();
        partition1Sums.add(0);
        for (int num = 1; num <= sum / 2; num++) {
            if (isSubsetSumPossible(arr, n, num)) partition1Sums.add(num);
        }
        int minDifference = sum - (2 * partition1Sums.get(0));
        for (int i = 1; i < partition1Sums.size(); i++) {
            int difference = sum - (2 * partition1Sums.get(i));
            if (difference < minDifference) minDifference = difference;
        }
        System.out.println(minDifference);
    }
}
