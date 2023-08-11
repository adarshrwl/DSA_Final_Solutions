import java.util.*;

public class TaskCompletionStepsCalculator {

    // Function to calculate the minimum number of steps to complete tasks
    public int calculateMinSteps(int numTasks, int[][] prerequisites) {
        List<Integer>[] dependencyGraph = new ArrayList[numTasks + 1];

        // Initialize the dependency graph
        for (int i = 1; i <= numTasks; i++) {
            dependencyGraph[i] = new ArrayList<>();
        }

        // Populate the dependency graph with prerequisites
        for (int[] prereq : prerequisites) {
            int prerequisiteTask = prereq[0];
            int dependentTask = prereq[1];
            dependencyGraph[dependentTask].add(prerequisiteTask);
        }

        // Create an array to memoize the steps required for each task
        int[] memoSteps = new int[numTasks + 1];

        int minSteps = 0;
        for (int i = 1; i <= numTasks; i++) {
            if (memoSteps[i] == 0) {
                minSteps = Math.max(minSteps, depthFirstSearch(i, dependencyGraph, memoSteps));
            }
        }
        return minSteps;
    }

    // Depth First Search to calculate steps required for a task
    private int depthFirstSearch(int task, List<Integer>[] dependencyGraph, int[] memoSteps) {
        if (memoSteps[task] > 0) {
            return memoSteps[task];
        }

        int maxSteps = 0;
        for (int prerequisite : dependencyGraph[task]) {
            maxSteps = Math.max(maxSteps, depthFirstSearch(prerequisite, dependencyGraph, memoSteps));
        }

        memoSteps[task] = maxSteps + 1;
        return memoSteps[task];
    }

    public static void main(String[] args) {
        int numTasks = 3;
        int[][] prerequisites = { { 1, 3 }, { 2, 3 } };
        TaskCompletionStepsCalculator solver = new TaskCompletionStepsCalculator();
        int result = solver.calculateMinSteps(numTasks, prerequisites);
        System.out.println("Minimum number of steps to complete tasks: " + result);
    }
}
