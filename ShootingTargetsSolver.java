public class ShootingTargetsSolver {

    public static int calculateMaxPoints(int[] targetValues) {
        int numTargets = targetValues.length;

        // Pad the array with 1 at the beginning and end
        int[] targets = new int[numTargets + 2];
        targets[0] = targets[numTargets + 1] = 1;
        System.arraycopy(targetValues, 0, targets, 1, numTargets);

        int[][] dp = new int[numTargets + 2][numTargets + 2];

        for (int length = 1; length <= numTargets; length++) {
            for (int left = 1; left + length - 1 <= numTargets; left++) {
                int right = left + length - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][i - 1] +
                            targets[left - 1] * targets[i] * targets[right + 1] +
                            dp[i + 1][right]);
                }
            }
        }

        return dp[1][numTargets];
    }

    public static void main(String[] args) {
        int[] targetValues = { 3, 1, 5, 8 };
        int maxPoints = calculateMaxPoints(targetValues);
        System.out.println("Maximum Points: " + maxPoints);
    }
}
