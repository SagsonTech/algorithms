package knapsack;
// 1. Initialize the knapsack function knapsack(int values[], int weights[], int n, int capacity) 
// 2. Add the base case for the lowest possible input (0) 
// 3. check if current item weight is less than equal to current capacity then: 
// 3.1. check the max profit for both possiblities of including or excluding the item 
// 3.2. Else proceed without including the item  


public class RecursiveKnapsack {
    public static int knapsack(int values[], int weights[], int n, int capacity) {
        if (n == 0 || capacity == 0) return 0;
        if (weights[n - 1] > capacity) return knapsack(values, weights, n - 1, capacity);
        return 
            Math.max(values[n - 1] + knapsack(values, weights, n - 1, capacity - weights[n - 1]), knapsack(values, weights, n - 1, capacity));
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30, 40, 50 };
        int[] values = { 60, 100, 120, 240, 300 };
        int n = weights.length;
        int capacity = 100;
        System.out.println(knapsack(values, weights, n, capacity));
    }
}
