import java.util.Arrays;

public class DecreasingDiffSubseqLengthCalculator {

    // Constant to represent an increment of one
    static int INCREMENT = 1;

    // Function to calculate the length of the longest subsequence
    // where the difference between elements is less than or equal to a given value
    // k
    public static int calculateLength(int[] values, int k) {
        int n = values.length;
        int[] dp = new int[n];

        Arrays.fill(dp, INCREMENT);

        // Compute the length of the longest subsequence for each element
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (values[i] < values[j] && Math.abs(values[i] - values[j]) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum length in the dp array
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15 };
        int k = 3;

        // Calculate the length of the longest subsequence with given k
        int length = calculateLength(values, k);
        System.out.println("Length of Longest Subsequence: " + length);
    }
}
