package knapsack.problems;

// problem statement 
// you are given an array of size n and a difference diff. You have to find the number of subsets whose difference of sum is equal to diff 
// Example 
// arr = {1, 1, 2, 3}, diff = 1 
// output = 3 
// since we have 3 subset partitions whose difference is 3
// 1. {1,1,2}, {3}
// 2. {1,3}, {1, 2}
// 2. {1,3}, {1, 2}

// logic 
// sum(s1) - sum(s2) = diff ---> eq 1
// sum(s1) + sum(s2) = sum(arr) ---> eq 2
// => 2 * sum(s1) = diff + sum(arr)
// => sum(s1) = (diff + sum(arr)) / 2 ---> therefore we have to find the number of subsets in arr that have sum = sum(s1)

public class CountNumberOfSubsetsWithDifference {
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    public static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int n = arr.length;
        int diff = 1;
        int sumOfSubset1 = (Math.abs(diff + findSum(arr)) / 2);
        System.out.println(countSubsets(arr, n, sumOfSubset1));
    }
}
