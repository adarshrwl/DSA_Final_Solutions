public class ClothingCostMinimizer {

    // Constant to represent the maximum integer value
    static int MAX_INT = Integer.MAX_VALUE;

    // Constants to represent indices of clothing options
    static int OPTION_A = 0;
    static int OPTION_B = 1;
    static int OPTION_C = 2;

    // Function to find the minimum cost of clothing
    public static int findMinimumCost(int numPeople, int[][] clothingPrices) {
        // Initialize minimum cost for each person with the maximum integer value
        int minCostPerson1 = MAX_INT;
        int minCostPerson2 = MAX_INT;
        int minCostPerson3 = MAX_INT;

        // Traverse the clothing prices matrix and find the minimum cost for each person
        for (int i = 0; i < numPeople; i++) {
            minCostPerson1 = Math.min(minCostPerson1, clothingPrices[i][OPTION_A]);
            minCostPerson2 = Math.min(minCostPerson2, clothingPrices[i][OPTION_B]);
            minCostPerson3 = Math.min(minCostPerson3, clothingPrices[i][OPTION_C]);
        }

        // Calculate the total minimum cost for all people
        int totalMinCost = minCostPerson1 + minCostPerson2 + minCostPerson3;
        return totalMinCost;
    }

    public static void main(String[] args) {
        // Number of people
        int numPeople = 3;

        // Clothing price matrix: [Person][Clothing Option]
        int[][] clothingPrices = {
                { 14, 4, 11 },
                { 11, 14, 3 },
                { 14, 2, 10 }
        };

        // Calculate the minimum cost of clothing
        int minimumCost = findMinimumCost(numPeople, clothingPrices);

        // Print the minimum cost
        System.out.println("Minimum Cost of Clothing: " + minimumCost);
    }
}
