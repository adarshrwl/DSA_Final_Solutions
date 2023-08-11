import java.util.Arrays;

public class ShortestPathsAlgorithm {

    // Inner class to represent edges in the graph
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Function to find shortest paths from a source vertex using Bellman-Ford algorithm
    public static int[] calculateShortestPaths(int[][] graph, int source) {
        int numVertices = graph.length;

        // Initialize an array to store the shortest distances from the source vertex
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Perform relaxation steps iteratively
        for (int i = 0; i < numVertices - 1; i++) {
            for (Edge edge : getEdges(graph)) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    // Update distance[v] if a shorter path is found from source to v
                    distances[v] = distances[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : getEdges(graph)) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;
            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                // If distance[u] + weight < distance[v], a negative cycle exists
                throw new RuntimeException("Graph contains negative cycle.");
            }
        }

        return distances; // Return the array of shortest distances
    }

    // Utility function to convert the graph matrix into an array of edges
    private static Edge[] getEdges(int[][] graph) {
        int numVertices = graph.length;
        int edgeCount = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (graph[i][j] != 0) {
                    edgeCount++;
                }
            }
        }

        // Create and populate an array to store the edges
        Edge[] edges = new Edge[edgeCount];
        int idx = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (graph[i][j] != 0) {
                    edges[idx++] = new Edge(i, j, graph[i][j]);
                }
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        // Define the weighted adjacency matrix representing the graph
        int[][] graph = {
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {6, 0, 5, -4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Calculate shortest paths from source vertex 0
        int[] shortestPaths = calculateShortestPaths(graph, 0);
        System.out.println(Arrays.toString(shortestPaths));
    }
}
