import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinsDistributionSolver {

    // Constant to represent a single coin
    static int COIN = 1;

    // Function to calculate the minimum coins required for distribution
    public static int calculateMinCoins(int[] playerScores) {
        int n = playerScores.length;
        int[] coins = new int[n];
        int totalCoins = 0;

        // Initialize coins array with all 1s
        Arrays.fill(coins, COIN);

        // Traverse from left to right and update coins based on increasing scores
        for (int i = 1; i < n; i++) {
            if (playerScores[i] > playerScores[i - 1]) {
                coins[i] = coins[i - 1] + 1;
            }
        }

        // Traverse from right to left and update coins based on decreasing scores
        for (int i = n - 2; i >= 0; i--) {
            if (playerScores[i] > playerScores[i + 1] && coins[i] <= coins[i + 1]) {
                coins[i] = coins[i + 1] + 1;
            }
        }

        // Calculate total number of coins required
        for (int i = 0; i < n; i++) {
            totalCoins += coins[i];
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        int[] playerScores = { 1, 0, 2 };

        // Calculate the minimum coins required for distribution
        int minCoinsRequired = calculateMinCoins(playerScores);

        // Print the minimum coins required
        System.out.println("Minimum Coins Required: " + minCoinsRequired);
    }
}
