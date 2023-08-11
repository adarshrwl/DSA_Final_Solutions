import java.util.ArrayList;
import java.util.List;

public class ConnectionReorienter {

    public static int minReorientations(int nodes, int[][] connections) {
        List<Integer>[] adjacencyList = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Create an adjacency list to represent the graph
        for (int[] connection : connections) {
            int fromNode = connection[0];
            int toNode = connection[1];
            adjacencyList[fromNode].add(toNode);
        }

        int[] visited = new int[nodes];
        int[] reorientationCount = new int[1];
        dfs(0, adjacencyList, visited, reorientationCount);

        return reorientationCount[0];
    }

    private static void dfs(int node, List<Integer>[] adjacencyList, int[] visited, int[] reorientationCount) {
        visited[node] = 1; // Mark node as visited

        for (int neighbor : adjacencyList[node]) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adjacencyList, visited, reorientationCount);
            } else if (visited[neighbor] == 1) {
                reorientationCount[0]++; // Increment reorientation count
            }
        }

        visited[node] = 2; // Mark node as processed
    }

    public static void main(String[] args) {
        int nodes = 6;
        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        int reorientationCount = minReorientations(nodes, connections);
        System.out.println("Minimum Reorientations: " + reorientationCount);
    }
}
