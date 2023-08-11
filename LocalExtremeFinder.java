public class LocalExtremeFinder {

    // Function to find the index of a local extreme in an array
    public static int findIndexOfLocalExtreme(int[] values) {
        int currentIndex = 0; // Start from the first element
        int neighborIndex = 0; // Initialize the neighbor index

        while (true) {
            neighborIndex = currentIndex; // Initialize the neighbor as the current index

            // Check if the left neighbor is greater or smaller
            if (currentIndex > 0 && values[currentIndex - 1] > values[currentIndex]) {
                neighborIndex = currentIndex - 1; // Update neighbor index
            }
            // Check if the right neighbor is greater or smaller
            if (currentIndex < values.length - 1 && values[currentIndex + 1] > values[neighborIndex]) {
                neighborIndex = currentIndex + 1; // Update neighbor index
            }

            // If the neighbor index hasn't changed, a local extreme is found
            if (neighborIndex == currentIndex) {
                break;
            }
            currentIndex = neighborIndex; // Move to the next position
        }
        return currentIndex; // Return the index of the local extreme
    }

    public static void main(String[] args) {
        int[] values = { 1, 3, 5, 4, 2, 6 };

        // Find the index of the local extreme using the local-extreme-finding algorithm
        int localExtremeIndex = findIndexOfLocalExtreme(values);

        // Print the index and value of the local extreme
        System.out.println("Index of Local Extreme: " + localExtremeIndex);
        System.out.println("Value of Local Extreme: " + values[localExtremeIndex]);
    }
}
